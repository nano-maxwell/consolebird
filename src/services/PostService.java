package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.*;

public class PostService {
    private List<Post> posts = new ArrayList<>();

    public void createPost(Scanner sc, User user){
        System.out.print("Enter post title: ");
        String title = sc.nextLine();

        System.out.print("Enter post content: ");
        String content = sc.nextLine();

        Post post = new Post(title, content, user);
        posts.add(post);
        user.addPost(post);

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
                System.out.println("\n-------------------------------\n[" + (i+1) + "] " + posts.get(i));
                System.out.println("1. Upvote | 2. Downvote | 3. Next");
                int choice = Integer.parseInt(sc.nextLine());
                try {
                    switch (choice) {
                        case 1:
                            posts.get(i).upvote();
                            break;
                        case 2:
                            posts.get(i).downvote();
                            break;
                        case 3:
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                }
                if (choice == 3) break;
                System.out.println("-------------------------------");
            }
        }
        System.out.println("No more posts to show...");
    }
}
