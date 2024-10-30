/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package blog;

import blog.model.PostRepository;
import blog.view.PostView;
import blog.view.MenuView;
import blog.controller.PostController;
/**
 * @author marcelkuczek
 */

/**
 * Main class for the blog application.
 *
 * Command line argument order:
 * 1. Author's name (String) [Optional]
 *
 * Example usage:
 * java blog.Main "Marcel Kuczek"

 * If no arguments are provided or the argument count is incorrect,
 * the application will interactively ask for input from the user.
 * 
 * @author marcelkuczek
 * @version 1.0
 */

public class Main {
    /**
     * The main method is the entry point of the application.
     * 
     * @param args Command line arguments, where the first argument is the author's name (optional)
     */
    public static void main(String[] args) {
        PostRepository repository = new PostRepository();
        MenuView menuView = new MenuView();
        PostView postView = new PostView();
        PostController postController = new PostController(postView, menuView, repository);
        
        // Start the application with the given command line arguments
        postController.start(args); 
    }
}
