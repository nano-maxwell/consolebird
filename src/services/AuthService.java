package services;

import java.util.HashMap;
import java.util.Scanner;

import models.User;

public class AuthService {
    private HashMap<String, User> users = new HashMap<>();
    private User currentUser;
    
    public void signUp(Scanner sc) {
        System.out.println("Choose Your Username: ");
        String username = sc.nextLine().strip().toLowerCase();

        if(users.containsKey(username)){
            System.out.println("Username already exists, please try again.");
            signUp(sc);
            return;
        } else if (username.isBlank()){
            System.out.println("Username must not be blank, please try again.");
            signUp(sc);
            return;
        } else if (username.chars().anyMatch(Character::isWhitespace)){
            System.out.println("Username must not contain any spaces, please try again.");
            signUp(sc);
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine().strip();
        if (password.isBlank()){
            System.out.println("Password must not be blank, please try again.");
            signUp(sc);
            return;
        } else if (password.chars().anyMatch(Character::isWhitespace)){
            System.out.println("Password must not contain any spaces, please try again.");
            signUp(sc);
            return;
        }

        User newUser = new User(username, password);
        users.put(username, newUser);
        currentUser = newUser;

        System.out.println("User created! You are currently logged in as " + username);
    }

    public void logIn(Scanner sc){
        System.out.println("Enter Username: ");
        String username = sc.nextLine();

        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        User user = users.get(username);

        if(user != null && user.getPassword().equals(password)){
            currentUser = user;
            System.out.println("Welcome back, " + username + "!");
        } else System.out.println("Invalid Credentials.");
    }
    
    public User getCurrentUser(){
        return currentUser;
    }

    public void logOut(){
        currentUser = null;
        System.out.println("You have been logged out.\n");
    }

    public boolean isLoggedIn(){
        return currentUser != null;
    }
}
