package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Post;

public class PostService {
    private List<Post> posts = new ArrayList<>();

    public void createPost(Scanner scanner, String username){
        System.out.print("Enter post title: ");
        String title = scanner.nextLine();

        System.out.print("Enter post content: ");
        String content = scanner.nextLine();

        Post post = new Post(title, content, username);
        posts.add(post);

        System.out.println("Post created!");
    }

    public void viewPosts(){
        if(posts.isEmpty()){
            System.out.println("No posts yet...");
            return;
        }

        for(int i = 0; i < posts.size(); i++){
            System.out.println("[" + i + "] " + posts.get(i));
        }
    }
}