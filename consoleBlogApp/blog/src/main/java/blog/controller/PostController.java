/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package blog.controller;

import blog.model.PostRepository;
import blog.model.PostNotFoundException;
import blog.view.PostView;
import blog.view.MenuView;
import java.util.List;
import java.util.Scanner;
import blog.model.Post;

/**
 * The PostController class manages the interaction between the user and the blog's
 * model (PostRepository) and views (PostView and MenuView).
 * It handles user input, controls the flow of the application, and performs
 * actions related to blog posts.
 * 
 * @author marcelkuczek
 * @version 1.0
 */
public class PostController {
    private final PostView postView; 
    private final MenuView menuView; 
    private final PostRepository repository; 
    private final Scanner scanner; 

    /**
     * Constructor for the PostController class.
     * 
     * @param postView The view for displaying posts
     * @param menuView The view for displaying menus
     * @param repository The repository for managing posts
     */
    public PostController(PostView postView, MenuView menuView, PostRepository repository) {
        this.postView = postView;
        this.menuView = menuView;
        this.repository = repository;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the main loop of the application. It checks for command-line arguments
     * and allows the user to interact with the blog through a menu system.
     * 
     * @param args Command-line arguments passed to the application
     */
    public void start(String[] args) {
        String author;
        if (args.length == 1) {
            System.out.println("Running with command-line arguments");
            author = args[0];
        } else {
            System.out.println("No valid command-line arguments. Starting interactive mode");
            author = postView.getAuthorFromInput(); // Prompt for author name if no arguments are provided
        }

        List<Post> postsByAuthor = repository.getPostsByAuthor(author);
        postView.showPosts(postsByAuthor); // Display posts by the author

        boolean running = true;
        
        while (running) {
            int choice; 
            
            try {
                choice = menuView.displayMenu(); // Display the menu and get the user's choice
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    String chosenAuthor = postView.getAuthorByChoice(); // Get the author's name from user
                    try {
                        List<Post> posts = repository.getPostsByAuthor(chosenAuthor);
                        if (posts.isEmpty()) {
                            throw new PostNotFoundException("No posts found for this author: " + chosenAuthor);
                        }
                        postView.showPosts(posts); // Show posts for the selected author
                    } catch (PostNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    Post newPost = postView.addPost(); // Prompt for new post details
                    System.out.println(newPost); // Display the new post
                    repository.addPost(newPost); // Add the new post to the repository
                    System.out.println("Post added.");
                    break;

                case 3:
                    String postTitleToDelete = postView.deletePost(); // Get title of post to delete
                    repository.deletePost(postTitleToDelete); // Delete the post from the repository
                    break;

                case 4:
                    int choice2 = menuView.modifyMenu(); // Display modification options
                    String postTitleToModify = postView.selectPostToModify(); // Get title of post to modify
                    switch (choice2) {
                        case 1:
                            String newTitle = postView.modifyPost(); // Get new title from user
                            repository.modifyTitle(postTitleToModify, newTitle); // Modify post title
                            break;

                        case 2:
                            String newContent = postView.modifyPost(); // Get new content from user
                            repository.modifyContent(postTitleToModify, newContent); // Modify post content
                            break;

                        default:
                            System.out.println("Invalid choice, please try again.");
                            break;
                    }
                    break;

                case 5:
                    running = false; // Exit the loop to stop the application
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }   
        } 
    }
}
