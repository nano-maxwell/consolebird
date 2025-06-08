package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import utils.DateUtils;

public class User {
    private String username;
    private String password;
    private String bio;
    private LocalDateTime joinDate;
    private List<Post> posts = new ArrayList<>();

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.joinDate = LocalDateTime.now();
    }

    public String getProfile(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Username: ").append(this.username)
            .append("\n").append("Joined ").append(DateUtils.timeSince(joinDate))
            .append("\n").append("About: ").append(this.getBio());

        return stringBuilder.toString();
    }

    public String getUsername(){
        return username;
    }

    public void changeUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getBio(){
        return bio;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public void addPost(Post post){
        posts.add(post);
    }
}
