package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Post;

public class PostService {
    private List<Post> posts = new ArrayList<>();

    public void createPost(Scanner sc, String username){
        System.out.print("Enter post title: ");
        String title = sc.nextLine();

        System.out.print("Enter post content: ");
        String content = sc.nextLine();

        Post post = new Post(title, content, username);
        posts.add(post);

        System.out.println("Post created!");
    }

    public void viewPosts(Scanner sc){
        if(posts.isEmpty()){
            System.out.println("No posts yet...");
            return;
        }

        System.out.println("-------------------------------");
        for(int i = 0; i < posts.size(); i++){
            while (true) {
                System.out.println("[" + (i+1) + "] " + posts.get(i));
                System.out.println("1. Upvote | 2. Downvote | 3. Next");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        posts.get(i).upvote();
                        break;
                    case 2:
                        posts.get(i).downvote();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid input.");
                }
                System.out.println("-------------------------------");
            }
        }
    }
}