/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration_and_login;

import java.util.Scanner;

/**
 * Registration and Login system
 * This class handles user registration with validation and functionality
 * @author Student
 */
public class Registration_And_Login {
    private String username;
    private String password;
    private String phoneNumber;
    
    //====================================
    // checkUserName()
    //====================================
    //Validation method
    public boolean checkUserName(){
        return username.contains("_") && username.length()<=5;
    }
    //====================================
    // checkPasswordComplexity()
    //====================================
    //Checks if password has an uppercase, number, special character and at least 8 chars 
    public boolean checkPasswordComplexity(){
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;
        
         for(int i=0; i< password.length(); i++){
            char ch=password.charAt(i);
            
            if(Character.isUpperCase(ch)){
                hasUpperCase = true;
            }else if(Character.isDigit(ch)){
                hasNumber = true;
            }else if(!Character.isLetterOrDigit(ch)){
                hasSpecialCharacter = true;
            }
    }
         return password.length()>= 8 && hasUpperCase && hasNumber && hasSpecialCharacter;
    }
    
    //=======================================================
    // checkCellPhoneNumber()
    //=======================================================
    //Checks SA's phone numberformat (+27 followed by 9 digits)
    public boolean checkCellPhoneNumber(){
        return phoneNumber.startsWith("+27") && phoneNumber.length() == 12;
    }
    
    //=======================================================
    // registerUser()
    //=======================================================
    
    public String registerUser(){
        if(!checkUserName()){
            return "Username is not correctly formatted; Please ensure that your username contains an underscore and is not more than five characters in length.";
        }
        if(!checkPasswordComplexity()){
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()){
            return "Cellphone number is incorrectly formatted or does not contain the international code.";
        }
        return "User has been registered successfully.";
    }
    
    //=======================================================
    // loginUser()
    //=======================================================
    
    public boolean loginUser(String inputUsername, String inputPassword){
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
    
    //========================================================
    // returnLoginStatus()
    //========================================================
    // Handles and returns appropriate welcome or error message
    //========================================================
    
    public String returnLoginStatus(String inputUsername, String inputPassword, String firstName, String lastName){
        if(inputUsername.equals(username) && inputPassword.equals(password)){
            return "Welcome " + firstName + " " + lastName +"  " + "it is great to see you.";
        }
        else if(inputUsername.equals(username) && !inputPassword.equals(password)){
            return "Incorrect Password. Please try again.";
        }
        else if(!inputUsername.equals(username) && inputPassword.equals(password)){
            return "Incorrect username. Please try again.";
        }else{
            return "Username and password are incorrect. Please try again.";
        }
    }
    //===========================================================
    // MAIN METHOD
    //===========================================================

    public static void main(String[] args) {
         try (Scanner input = new Scanner(System.in)) {
             Registration_And_Login user = new Registration_And_Login();
             
             //========================================================
             //REGISTRATION
             //========================================================
             
             System.out.println("Enter your username:");
             user.username = input.nextLine();
             
             System.out.println("Enter your password:");
             user.password = input.nextLine();
             
             System.out.println("Enter your phone number:");
             user.phoneNumber = input.nextLine();
             
             System.out.println(user.registerUser());
             
             //=======================================================
             //LOGIN
             //=======================================================
             
             System.out.println("\nEnter your username:");
             String loginUsername = input.nextLine();
             
             System.out.println("Enter your password:");
             String loginPassword = input.nextLine();
             
             System.out.println("Enter your first name:");
             String firstName = input.nextLine();
             
             System.out.println("Enter your last name:");
             String lastName = input.nextLine();
             
             System.out.println(user.returnLoginStatus(loginUsername, loginPassword, firstName, lastName));
         }
    }
    
}

//=========================================================================
// REFERENCE LIST (HAVARD STYLE):
//=========================================================================
// Oracle (2024) Java Tutorials. Available at: https://docs.oracle.com/javase/tutorial/
//
// W3Schools (2024) Java Tutorials. Available at: https://www.w3schools.com/java/

