package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.*;

public class PostService {
    private List<Post> posts = new ArrayList<>();

    public void createPost(Scanner scanner, User user){
        System.out.print("Enter post title: ");
        String title = scanner.nextLine();

        System.out.print("Enter post content: ");
        String content = scanner.nextLine();

        Post post = new Post(title, content, user);
        posts.add(post);
        user.addPost(post);

        System.out.println("Post created!");
    }

    public void viewPosts(Scanner scanner, User user){
        if(posts.isEmpty()){
            System.out.println("-------------------------------");
            System.out.println("\nNo posts yet...");
            return;
        }

        System.out.println("-------------------------------");
        for(int i = 0; i < posts.size(); i++){
            while (true) {
                System.out.println("\n-------------------------------\n[" + (i+1) + "] " + posts.get(i).toString());
                System.out.println("1. Upvote | 2. Downvote | 3. Comment | 4. Next");
                int choice = Integer.parseInt(scanner.nextLine());
                try {
                    switch (choice) {
                        case 1:
                            posts.get(i).upvote();
                            break;
                        case 2:
                            posts.get(i).downvote();
                            break;
                        case 3:
                            posts.get(i).addComment(user, scanner);
                            System.out.println("-------------------------------");
                            System.out.println(posts.get(i).toString());
                            System.out.println("-------------------------------");
                            break;
                        case 4:
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                }
                if (choice == 3) break;
                System.out.println("-------------------------------");
            }
        }
        System.out.println("\nNo more posts to show...");
    }
}
