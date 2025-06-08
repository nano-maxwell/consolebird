package models;

import java.time.LocalDateTime;
import utils.DateUtils;

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

    public void upvote(){ this.upvotes++; }
    public void downvote(){ this.downvotes++; }

    public String toString(){
        
        return author.getUsername() + ": " + content + 
        "\n[+] " + upvotes + " | " + DateUtils.timeSince(timestamp);
    }

    public int getNetUpvotes(){
        return upvotes - downvotes;
    }

    public void delete(){
        parent.comments.remove(this);
    }
}
