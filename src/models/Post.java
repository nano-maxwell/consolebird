package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Post {
    private User author;
    private String title;
    private String content;
    private final LocalDateTime timestamp;
    private int upvotes;
    private int downvotes;
    List<Comment> comments = new ArrayList<>();

    public Post(String title, String content, User author){
        this.title = title;
        this.content = content;
        this.author = author;
        this.timestamp = LocalDateTime.now();
        this.upvotes = 0;
        this.downvotes = 0;
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
        String timeStr = timestamp.format(formatter);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(title).append(" by ").append(author.getUsername())
        .append("\n").append(content)
        .append("\n[+] ").append(upvotes).append(" | [-] ").append(downvotes).append(" | ").append(timeStr);
        
        Optional<Comment> topComment = comments.stream()
            .max(Comparator.comparingInt(Comment::getNetUpvotes));
        
        if (topComment.isPresent()){
            stringBuilder.append("\n").append(topComment.get());
        } else {
            stringBuilder.append("\nNo comments yet...");
        }


        return stringBuilder.toString();
    }

    public void upvote(){ upvotes++; }
    public void downvote(){ downvotes++; }

    public void addComment(User author, Scanner scanner){
        System.out.print("Comment content: ");
        String content = scanner.nextLine();
        if (content.isBlank()) {
            System.out.println("Comment must not be blank.");
            addComment(author, scanner);
            return;
        }

        comments.add(new Comment(author, content, this));
    }
}