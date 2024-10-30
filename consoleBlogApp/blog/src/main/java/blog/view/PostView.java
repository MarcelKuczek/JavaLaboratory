/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package blog.view;

import blog.model.Post;
import java.util.List;
import java.util.Scanner;

/**
 * The PostView class is responsible for interacting with the user,
 * allowing them to view, add, modify, and delete posts.
 * 
 * @author marcelkuczek
 * @version 1.0
 */
public class PostView {
    private final Scanner scanner;
    
    /**
     * Constructor for the PostView class.
     * 
     */
    public PostView() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Prompts the user to enter the author's name.
     * 
     * @return The author's name entered by the user
     */
    public String getAuthorFromInput() {
    System.out.print("Enter the author's name (first author: Marcel Kuczek): ");
    String input = scanner.nextLine();
    
    if (input.isEmpty()) {
        return "Marcel Kuczek";
    }
    return input;
}


    /**
     * Displays a list of authors and allows the user to choose one.
     * 
     * @return The name of the selected author by the user
     */
    public String getAuthorByChoice() {
        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("---------------------------------------------");
            System.out.println("Which author's posts do you want to see?: ");
            System.out.println("1. Marcel Kuczek");
            System.out.println("2. Jan Kowalski");
            System.out.println("3. Jakub Nowak");
            System.out.println("---------------------------------------------");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice, please enter a number between 1 and 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();
            }
        }

        return switch (choice) {
            case 1 -> "Marcel Kuczek";
            case 2 -> "Jan Kowalski";
            case 3 -> "Jakub Nowak";
            default -> "Marcel Kuczek";
        };
    }

    /**
     * Displays a list of posts to the user.
     * 
     * @param posts The list of posts to display
     */
    public void showPosts(List<Post> posts) {
        for (Post post : posts) {
            System.out.println(post);
        }
    }
    
    /**
     * Prompts the user to add a new post and returns the created Post object.
     * 
     * @return The new Post object created by the user
     */
    public Post addPost() {
        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("---------------------------------------------");
            System.out.println("Select an author: ");
            System.out.println("1. Marcel Kuczek");
            System.out.println("2. Jan Kowalski");
            System.out.println("3. Jakub Nowak");
            System.out.println("---------------------------------------------");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice, please enter a number between 1 and 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();
            }
        }
        
        String author = switch (choice) {
            case 1 -> "Marcel Kuczek";
            case 2 -> "Jan Kowalski";
            case 3 -> "Jakub Nowak";
            default -> "Marcel Kuczek";
        };
                        
        System.out.println("Enter the title of the post?: ");
        String title = scanner.nextLine();
        System.out.println("Enter the content of the post?: ");
        String content = scanner.nextLine();
            
        return new Post(title, author, content);     
    }
    
    /**
     * Prompts the user to enter the title of the post they want to delete.
     * 
     * @return The title of the post to delete
     */
    public String deletePost() {
        System.out.println("Enter the title of the post you wish to delete: ");
        String title = scanner.nextLine();
        return title;
    }

    /**
     * Prompts the user to enter the title of the post they want to modify.
     * 
     * @return The title of the post to modify
     */
    public String selectPostToModify() {
        System.out.println("Enter the title of the post you want to modify: ");
        String title = scanner.nextLine();
        return title;
    }
    
    /**
     * Prompts the user to enter a new title or content for the post.
     * 
     * @return The new title or content entered by the user
     */
    public String modifyPost() {
        System.out.println("Enter new: ");
        String title = scanner.nextLine();
        return title;
    }
}
