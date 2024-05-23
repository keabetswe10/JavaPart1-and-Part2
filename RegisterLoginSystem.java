/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.register_login1;
import javax.swing.JOptionPane;
/**
 *
 * @author Keabetswe malwa
 */

public class RegisterLoginSystem {
    private static String firstname;
    private static String lastname;
    private static String username;
    private static String password;
    
    // Maximum length for the username
    private static final int MAX_USERNAME_LENGTH = 20;
    private static int taskNumber = 0; // Add taskNumber variable

    public static void main(String[] args) {
        //Get the number of tasks from the user
        
       
        // Register a new user
        register();

        // Login with registered credentials
        login();
    }

    private static void register() {
        firstname = JOptionPane.showInputDialog("Enter a firstname:");
        lastname = JOptionPane.showInputDialog("Enter a lastname:");
        username = JOptionPane.showInputDialog("Enter a username (maximum \" + MAX_USERNAME_LENGTH + \" characters, must contain an underscore):");
        password = JOptionPane.showInputDialog("Create a password:");

        // Check if any field is empty
        if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the required fields");
            register(); // Allows the user to input all fields that are required
        } else {
            // Check username length
            if (!checkUserName(username)) {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that the username contains an underscore and is no more than \" + MAX_USERNAME_LENGTH + \" characters in length.");
                register(); // Repeat for username
            } else {
                // Check password strength
                if (!meetsPasswordComplexity(password)) {
                    JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
                    register(); // Re-prompt for password
                } else {
                    JOptionPane.showMessageDialog(null, "Registration successful. You can now login.");
                }
            }
        }
    }

    private static void login() {
        String inputUsername = JOptionPane.showInputDialog("Enter your username:");
        String inputPassword = JOptionPane.showInputDialog("Enter your password:");

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
             JOptionPane.showMessageDialog(null, "Login successful!");
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban " + inputUsername + "!");
             
             
            // Loop until the user chooses to quit
            while (true) {
            //Provide user with options
             String[] options = {"Add task", "Show report", "Quit"};
              int choice = JOptionPane.showOptionDialog(null, "Please choose an option:", "Welcome!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    // Add task option selected
                    addTask();
                    break;
                case 1:
                    // Show report option selected
                    showReport();
                    break;
                case 2:
                    // Quit option selected
                    quit();
                    break;
                default:
                    // This should not occur
                    JOptionPane.showMessageDialog(null, "Invalid option selected");
                    break;
            }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password. Please try again.");
            login(); // Recursive call for reattempting login
        }
    }
     private static void addTask() {
         // Increment task number
        taskNumber++;

        // Ask the user to enter task details
        String taskName = JOptionPane.showInputDialog("Enter the name of the task:");
        int taskNumber = Integer.parseInt(JOptionPane.showInputDialog("enter task number:"));
        String taskDescription = JOptionPane.showInputDialog("Enter task description (50 charatcters or less):");
        //Check if Description is more than 50 characters
        if (taskDescription.length()>50){
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            addTask();//Allows the user to Re-enter the required
        }
        String developerFirstName = JOptionPane.showInputDialog("Enter developer's first name:");
        String developerLastName = JOptionPane.showInputDialog("Enter developer's last name:");
        String developerDetails = developerFirstName + " " + developerLastName;
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
        int taskId = taskNumber; // Use the auto-incremented task number
        // Menu for selecting task status
        String[] statusOptions = {"To Do", "Doing", "Done"};
        int statusChoice = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, statusOptions, statusOptions[0]);
        String taskStatus;
        switch (statusChoice) {
           case 0:
              taskStatus = "To Do";
              break;
           case 1:
              taskStatus = "Doing";
              break;
           case 2:
              taskStatus = "Done";
              break;
           default:
              JOptionPane.showMessageDialog(null, "Invalid status selected. Setting status to To Do.");
              taskStatus = "To Do"; // Default status
              break;
    }
        
        // Display task details
        JOptionPane.showMessageDialog(null, "Task captured successfully:\n" +
                "Task Name: " + taskName + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Duration: " + taskDuration + " hours\n" +
                "Task Status: " + taskStatus);
    }
     
    
        private static void showReport() {
        // Display a message indicating that the feature is in development
        JOptionPane.showMessageDialog(null, "This feature is still in development. Coming soon!");
    }

    private static void quit() {
        // Confirm if the user wants to quit
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Thank you for your time. Goodbye!");
            System.exit(0); // Quit the program
        } else {
            login(); // Return to login screen
        }
         
        
    }
    private static boolean  meetsPasswordComplexity(String password){
          // Check if password meets complexity requirements
    boolean hasCapitalLetter = false;
    boolean hasNumber = false;
    boolean hasSpecialChar = false;

    if (password.length() < 8) {
        return false;
    }

    for (char ch : password.toCharArray()) {
        if (Character.isUpperCase(ch)) {
            hasCapitalLetter = true;
        } else if (Character.isDigit(ch)) {
            hasNumber = true;
        } else if (!Character.isLetterOrDigit(ch)) {
            hasSpecialChar = true;
        }
    }

    return hasCapitalLetter && hasNumber && hasSpecialChar;
}
        
    private static boolean checkUserName(String username) {
        // Check if username contains an underscore and is no more than 5 characters long
        return username.contains("_") && username.length() <= 5;
    }

    
}
    


      