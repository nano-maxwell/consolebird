package services;

import java.util.HashMap;
import java.util.Scanner;

import models.User;

public class AuthService {
    private HashMap<String, User> users = new HashMap<>();
    private User currentUser;
    
    public void signUp(Scanner sc) {
        System.out.println("Choose Your Username: ");
        String username = sc.nextLine();

        if(users.containsKey(username)){
            System.out.println("Username already exists, please try again.");
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

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
