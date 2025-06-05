package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String title;
    private String content;
    private User author;
    private LocalDateTime timestamp;
    private int upvotes;
    private int downvotes;

    public Post(String title, String content, User author){
        this.title = title;
        this.content = content;
        this.author = author;
        this.timestamp = LocalDateTime.now();
        this.upvotes = 0;
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
}