/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickblock_group2;

import java.awt.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BrickBlock_Group2 {

// Global Variables
private static final double BRICKWIDTH = 2.25;
private static final double BRICKHEIGHT = 7.625;

private static final double FTCCSURFACEAREA = 492072;
private static final double FTCCSUBTRACTWINDOWFRAMES = 16280;
private static final double FTCCSUBTRACTCOMPUTERFRONTFRAME = 15136;
private static final double FTCCSUBTRACTDOORS = 56320;
private static final double FTCCADDADENTIONS = 21917;
private static final double FTCCADDCORNERS = 23230;

// Variables for the program
public static double modularBrick = BRICKWIDTH * BRICKHEIGHT; 
public static double morterSpace = 0; 
public static String personName = "";
public static String personEmail = "";
public static String personOccupation = "";
public static double personPhoneNumber = 0; 
public static double total;

// Main Method
    public static void main(String[] args) 
    {   
     fullProgramMenu();
    }

// Open greeting method
  private static void openIntro()
     {
        JOptionPane.showMessageDialog(null, "Hello");
        personName = JOptionPane.showInputDialog("What is your name?");
        while ("".equals(personName.trim())) {
         JOptionPane.showMessageDialog(null, "Error, name cannot be blank!");
         personName = JOptionPane.showInputDialog("Enter Name ");
         }
        
        JOptionPane.showMessageDialog(null, "My name is " + personName);
        JOptionPane.showMessageDialog(null, "Hello! " + personName);
        personOccupation = JOptionPane.showInputDialog("What is your occupation " + personOccupation);
        while ("".equals(personOccupation.trim())) {
         JOptionPane.showMessageDialog(null, "Error, Occupation cannot be blank!");
         personOccupation = JOptionPane.showInputDialog("Enter Occupation or Type none if you wish to not disclose that information ");
         }
     }
  
 // Closing method
 public static void endingGreeting()
 {
 
 }

 //Personal Information Method
 public static void personalInformation()
 {
  personEmail = JOptionPane.showInputDialog("What is your Email:");
  while ("".equals(personEmail.trim())) {
         JOptionPane.showMessageDialog(null, "Error, Email cannot be blank!");
         personEmail = JOptionPane.showInputDialog("Enter Your Email ");
         }  
  
  personPhoneNumber = Double.parseDouble(JOptionPane.showInputDialog
       (null, "What is your Phone Number:"));
 }

 // Looped main menu
    private static void fullProgramMenu()
    {
     //method call for opening intro
     openIntro();
     // method call for personal information
     personalInformation();   
    
     // create string choices for the menu
    String[] choices = {"1. BrickBlock ", "2. Personal Measurements ", 
                    "3. Price calculator", "4. Quit"};

    String menu = "";

    // create the loop with a while loop
while (!menu.equals("4. Quit")) {
    menu = (String) JOptionPane.showInputDialog(null, "<html>Choose A Menu Item:<br><br></html>", "Main Menu", 
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
    if (menu == null) {
        break; 
    }

    // Switch statement for the looped menu
    switch (menu) {
        
        // Method call for project()
        case "1. BrickBlock ":
             project();
            break;
            
            // Method call for userinput()
        case "2. Personal Measurements ":
              userinput();
            break;
            
            //Method call for calculator()
        case "3. Price calculator":
            calculator();
            break;
            
            // case 4 closes the program
        case "4. Quit":           
            break;
        }
    }
    }

    // this is where all the guts of the main project will go
    private static void project() {
        DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
        total = FTCCSURFACEAREA + FTCCADDADENTIONS + FTCCADDCORNERS - FTCCSUBTRACTWINDOWFRAMES - FTCCSUBTRACTCOMPUTERFRONTFRAME - FTCCSUBTRACTDOORS;
        double bricks = total/modularBrick;
        JOptionPane.showMessageDialog(null,df2.format(bricks));
    }

    //extra, uses user input to calcualte the bricks in a given area
    private static void userinput() {
        String firstpoint = ("Make sure you double check your measurements!");
        JOptionPane.showMessageDialog(null, firstpoint);
        String secondpoint = ("Go double check your measurements!");
        
        
        int ans = JOptionPane.showOptionDialog(new JFrame(), "Did You double check your measurements? ","Block to Brick calculator",
         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
        switch (ans) {
            case JOptionPane.YES_OPTION:
                userMeasurements();
                break;
                
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, secondpoint);
                break;
                
            case JOptionPane.CLOSED_OPTION:
                String ninepoint = ("Opps, you closed the window");
                JOptionPane.showMessageDialog(null, ninepoint);
                break;
                
            default:
                break;
        }
        
    }
    
    // extra, will ask user for measurements and will calculate like user measurements, but add retail.
    private static void calculator() {
        
        //create the buttons for the question
        Object[] options = {"Reciept Please",
                    "No thank you",
                    "Exit"};
        Component frame = null;
        // create a button only box for the switch statement
        int choice = JOptionPane.showOptionDialog(frame,
        "Do you Want a receipt for the invoice ",
        "Calculator",
         JOptionPane.YES_NO_CANCEL_OPTION,
         JOptionPane.QUESTION_MESSAGE,
         null,
         options,
         options[2]);
        
        // create the switch statement for the users choice
        switch (choice) {
            case 0:
                Receipt();
                break;
                
            case 1:
                break;
                
            case 2:
                break;
                
            default:  
                break;
        }
    }
       private static void userMeasurements() {
           DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
           try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is your measurments? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double bricks = total/modularBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(bricks));
           
        
    }
        public static void printBillToFile() throws IOException
    {
     try
    {
         try (FileWriter myOutPutFile = new FileWriter(personEmail + ".txt")) {
             myOutPutFile.write(personName  + "\n");
             
             
            
         }
        System.out.println("You did it");
    }
     catch (IOException e)
     {
      System.out.print("An error occured");
     }
    }

    private static void Receipt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


