package app;
import java.util.Scanner;

import services.AuthService;
import services.PostService;

class BirdApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthService authService = new AuthService();
        PostService postService = new PostService();
        
        while (true) {
            System.out.println("Welcome to ConsoleBird!");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    authService.signUp(sc);
                    if(authService.isLoggedIn()){
                        runLoggedInMenu(sc, authService, postService);
                    }
                    break;
                case 2:
                    authService.logIn(sc);
                    if(authService.isLoggedIn()){
                        runLoggedInMenu(sc, authService, postService);
                    }
                    break;
                case 3:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid input.");
            }

        }
    }

    public static void runLoggedInMenu(Scanner sc, AuthService authService, PostService postService){
        while (authService.isLoggedIn()){
            System.out.println("\n------ ConsoleBird Menu ------");
            System.out.println("1. Create Post");
            System.out.println("2. View Posts");
            System.out.println("3. Log out");

            int loggedInChoice = Integer.parseInt(sc.nextLine());

            switch (loggedInChoice) {
                case 1:
                    postService.createPost(sc, authService.getCurrentUser());
                    break;
                case 2:
                    postService.viewPosts(sc, authService.getCurrentUser());
                    break;
                case 3:
                    authService.logOut();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}