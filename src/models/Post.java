package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String title;
    private String content;
    private String authorUsername;
    private LocalDateTime timestamp;
    private int upvotes;
    private int downvotes;

    public Post(String title, String content, String authorUsername){
        this.title = title;
        this.content = content;
        this.authorUsername = authorUsername;
        this.timestamp = LocalDateTime.now();
        this.upvotes = 0;
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
        String timeStr = timestamp.format(formatter);
        
        return "\"" + title + "\" by " + authorUsername + 
        "\n" + content +
        "\n[+] " + upvotes + " | [-] " + downvotes + " | " + timeStr + "\n";
    }

    public void upvote(){ upvotes++; }
    public void downvotes(){ downvotes++; }
}
