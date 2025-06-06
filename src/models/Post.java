package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
        
        return title + " by " + author.getUsername() + 
        "\n" + content +
        "\n[+] " + upvotes + " | [-] " + downvotes + " | " + timeStr;
    }

    public void upvote(){ upvotes++; }
    public void downvote(){ downvotes++; }

    public void addComment(User author){
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        if (content.isBlank())

        System.out.println("Comment content: ");
        comments.add(new Comment(author, content, this));
        sc.close();
    }
}