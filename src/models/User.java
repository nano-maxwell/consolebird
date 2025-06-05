package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String bio;
    private List<Post> posts = new ArrayList<>();

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public void changeUsername(String username){
        this.password = username;
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
