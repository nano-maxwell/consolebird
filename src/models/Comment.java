package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private User author;
    private String content;
    private final LocalDateTime timestamp;
    private int upvotes;
    private int downvotes;
    private final Post parent;

    public Comment(User author, String content, Post parent){
        this.author = author;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.upvotes = 0; 
        this.downvotes = 0;
        this.parent = parent;
    }

    public void upvote(){ upvotes++; }
    public void downvote(){ downvotes++; }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
        String timeStr = timestamp.format(formatter);
        
        return author.getUsername() + " - " + content + 
        "\n[+] " + upvotes + " | [-] " + downvotes + " | " + timeStr;
    }

    public void delete(){
        parent.comments.remove(this);
    }
}
