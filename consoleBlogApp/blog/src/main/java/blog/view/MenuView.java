/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package blog.view;

import java.util.Scanner;

/**
 * The MenuView class is responsible for displaying menus to the user.
 * It provides methods to display the main menu and the modification menu.
 * 
 * @author marcelkuczek
 * @version 1.0
 */
public class MenuView {
    
    private final Scanner scanner = new Scanner(System.in); 
    
    /**
     * Displays the main menu options to the user.
     * 
     * @return the user's choice
     */
    public int displayMenu() {
        int choice = -1;
        while (choice < 1 || choice > 5) {
            System.out.println("---------------------------------------------");
            System.out.println("What do you want?");
            System.out.println("1. View posts");
            System.out.println("2. Add post");
            System.out.println("3. Delete post");
            System.out.println("4. Modify post");
            System.out.println("5. Exit");
            System.out.println("---------------------------------------------");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice, please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();
            }
        }
        return choice; 
    }
    
    /**
     * Displays the modification menu options to the user.
     * 
     * @return the user's choice for modification.
     */
    public int modifyMenu() {
        int choice = -1;
        while (choice < 1 || choice > 2) {
            System.out.println("---------------------------------------------");
            System.out.println("Select an action: ");
            System.out.println("1. Modify title");
            System.out.println("2. Modify content");
            System.out.println("---------------------------------------------");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 2) {
                    System.out.println("Invalid choice, please enter 1 or 2.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();
            }
        }
        return choice;
    }
}
