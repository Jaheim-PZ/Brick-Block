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
// Main Method
    public static void main(String[] args) {   
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
    endingGreeting();
    }

// Open greeting method with validation
  private static void openIntro()
     {
        JOptionPane.showMessageDialog(null, "Hello");
        personName = JOptionPane.showInputDialog("What is your name?");
        while ("".equals(personName.trim())) {
         JOptionPane.showMessageDialog(null, "Error, name cannot be blank!");
         personName = JOptionPane.showInputDialog("Enter Name ");
         }
        JOptionPane.showMessageDialog(null, "Nice to meet you " + personName);
        personOccupation = JOptionPane.showInputDialog("What is your occupation " + personOccupation);
        while ("".equals(personOccupation.trim())) {
         JOptionPane.showMessageDialog(null, "Error, Occupation cannot be blank!");
         personOccupation = JOptionPane.showInputDialog("Enter Occupation or Type none if you wish to not disclose that information ");
         }
     }
  
 // Closing method
 public static void endingGreeting()
 {
     JOptionPane.showMessageDialog(null, "Thank you for using our application and have a wonderful day!");
 }

 //Personal Information Method with validation
 public static void personalInformation()
 {
  personEmail = JOptionPane.showInputDialog("What is your Email:");
  while ("".equals(personEmail.trim())) {
         JOptionPane.showMessageDialog(null, "Error, Email cannot be blank!");
         personEmail = JOptionPane.showInputDialog("Enter Your Email ");
         }  
  //need to do more validation for phone number and email -----------------------------------------------------------------------------------------
  personPhoneNumber = Double.parseDouble(JOptionPane.showInputDialog
       (null, "What is your Phone Number:"));
 }

    // this is where all the guts of the main project will go
    private static void project() {
        DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
        JOptionPane.showMessageDialog(null, "We measured all four walls and got an area of " +FTCCSURFACEAREA+" in inches.");
        
        double extra = FTCCADDADENTIONS + FTCCADDCORNERS;
        JOptionPane.showMessageDialog(null, "Then we measured the corners and indentions and got " +extra+" in inches.");
        
        double takeaway = FTCCSUBTRACTWINDOWFRAMES + FTCCSUBTRACTCOMPUTERFRONTFRAME + FTCCSUBTRACTDOORS;       
        JOptionPane.showMessageDialog(null, "Then we measured the windows, doors, and library front and back frames and got " +takeaway+" in inches.");
        
        
        total = FTCCSURFACEAREA + extra - takeaway;
        double bricks = total/modularBrick;
        JOptionPane.showMessageDialog(null,"Then we added the extra inches to the area then subtract the door and window space and got a total of "
                + ""+df2.format(total)+" in inches.");
        JOptionPane.showMessageDialog(null,"Which means we will need about "+df2.format(bricks)+" Plus an extra bundle or two for breakage and cuts.");
    }

    //extra, uses user input to calcualte the bricks in a given area
    private static void userinput() {
        String firstpoint = ("Make sure you double check your measurements!");
        JOptionPane.showMessageDialog(null, firstpoint);
        String secondpoint = ("Go double check your measurements and come back");
        
        
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
        DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
           // create string choices for the menu
    String[] choices = {"1. Modular  (7 5/8 x 2 1/4)",
                        "2. Queen    (7 5/8 x 2 3/4)", 
                        "3. Closure  (7 5/8 x 3 5/8)",
                        "4. Standard (8 x 2 1/4)",
                        "5. Jumbo    (8 x 2 3/4)",
                        "6. King     (9 5/8 x 2 5/8)",
                        "7. Roman    (11 5/8 x 1 5/8)",
                        "8. Norman   (11 5/8 x 2 1/4)",                    
                        "9. Utility  (11 5/8 x 3 5/8)",
                        "10. Quit"};

    String menu = "";
    double done = 1;
    // create the loop with a while loop
while (1 == done) {
    menu = (String) JOptionPane.showInputDialog(null, "<html>Which Brick are you going to use:<br><br></html>", "Bricks", 
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
    if (menu == null) {
        break; 
    }

    // Switch statement for the looped menu
    switch (menu) {
        
        // modular brick
        case "1. Modular  (7 5/8 x 2 1/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double mbricks = total/modularBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(mbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
           bricksNeeded = mbricks;
           done = 0;
           break;
                
            
        // queen brick    
        case "2. Queen    (7 5/8 x 2 3/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double qbricks = total/queenBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(qbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
           bricksNeeded = qbricks; 
           done = 0;
           break;
            
            
        // closure brick    
        case "3. Closure  (7 5/8 x 3 5/8)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double cbricks = total/closureBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(cbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
           bricksNeeded = cbricks; 
           done = 0;
           break;
            
            
        // standard brick    
        case "4. Standard (8 x 2 1/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double sbricks = total/standardBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(sbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
           bricksNeeded = sbricks;
           done = 0;
           break;
            
            
        // jumbo brick    
        case "5. Jumbo    (8 x 2 3/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double jbricks = total/jumboBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(jbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
           bricksNeeded = jbricks; 
           done = 0;
           break;
        
            
        // king brick    
        case "6. King     (9 5/8 x 2 5/8)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double kbricks = total/kingBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(kbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
           bricksNeeded = kbricks; 
           done = 0;
           break;
            
            
        // roman brick    
        case "7. Roman    (11 5/8 x 1 5/8)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double rbricks = total/romanBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(rbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
           bricksNeeded = rbricks; 
           done = 0;
           break;
            
            
        // norman brick    
        case "8. Norman   (11 5/8 x 2 1/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
            double nbricks = total/normanBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(nbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
           bricksNeeded = nbricks;
           done = 0;
           break;
            
            
        // utility brick    
        case "9. Utility  (11 5/8 x 3 5/8)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double ubricks = total/utilityBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(ubricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
           bricksNeeded = ubricks;
           done = 0;
           break;
            
        case "10. Quit":
            done = 0;
            break;
        default:
            done = 0;
            break;
        }
    }
//create the buttons for the question
        Object[] options = {"Reciept, Please",
                    "No thank you"};
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
                
                
            default:  
                break;
        }
    }
    
        
    
    // get user area and devide by brick of choice
    private static void userMeasurements() {
    DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
           // create string choices for the menu
    String[] choices = {"1. Modular  (7 5/8 x 2 1/4)",
                        "2. Queen    (7 5/8 x 2 3/4)", 
                        "3. Closure  (7 5/8 x 3 5/8)",
                        "4. Standard (8 x 2 1/4)",
                        "5. Jumbo    (8 x 2 3/4)",
                        "6. King     (9 5/8 x 2 5/8)",
                        "7. Roman    (11 5/8 x 1 5/8)",
                        "8. Norman   (11 5/8 x 2 1/4)",                    
                        "9. Utility  (11 5/8 x 3 5/8)",
                        "10. Quit"};

    String menu = "";

    // create the loop with a while loop
while (!menu.equals("10. Quit")) {
    menu = (String) JOptionPane.showInputDialog(null, "<html>Which Brick are you going to use:<br><br></html>", "Bricks", 
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
    if (menu == null) {
        break; 
    }

    // Switch statement for the looped menu
    switch (menu) {
        
        // modular brick
        case "1. Modular  (7 5/8 x 2 1/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double mbricks = total/modularBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(mbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
            break;
                
            
        // queen brick    
        case "2. Queen    (7 5/8 x 2 3/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double qbricks = total/queenBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(qbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
            break;
            
            
        // closure brick    
        case "3. Closure  (7 5/8 x 3 5/8)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double cbricks = total/closureBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(cbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
            break;
            
            
        // standard brick    
        case "4. Standard (8 x 2 1/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double sbricks = total/standardBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(sbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
            break;
            
            
        // jumbo brick    
        case "5. Jumbo    (8 x 2 3/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double jbricks = total/jumboBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(jbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
            break;
        
            
        // king brick    
        case "6. King     (9 5/8 x 2 5/8)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double kbricks = total/kingBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(kbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
            break;
            
            
        // roman brick    
        case "7. Roman    (11 5/8 x 1 5/8)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double rbricks = total/romanBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(rbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
            break;
            
            
        // norman brick    
        case "8. Norman   (11 5/8 x 2 1/4)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
            double nbricks = total/normanBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(nbricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
            break;
            
            
        // utility brick    
        case "9. Utility  (11 5/8 x 3 5/8)":
            try{
               total = Double.parseDouble(JOptionPane.showInputDialog(" What is the area of your project in Inches? "));
       }
       catch(NumberFormatException e){
           //error
        JOptionPane.showMessageDialog(null,"Error, not a number. Please try again.");
       }
           double ubricks = total/utilityBrick;
           JOptionPane.showMessageDialog(null, "This is the Aproximate number of bricks you will need "+df2.format(ubricks));
           JOptionPane.showMessageDialog(null, "Make sure you get extra bricks or a bundle more just incase of corners and breakage");
            break;
            
            
            
        case "10. Quit":
            break;
        }
    }}
    // creates a receipt
    private static void Receipt() {
         try
    {
         try (FileWriter myOutPutFile = new FileWriter(personEmail + ".txt")) {
              DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
              myOutPutFile.write("Name: " + personName  + "\n");
              myOutPutFile.write("Occupation: " + personOccupation + "\n");
              myOutPutFile.write("Email Address: " + personEmail + "\n");
              myOutPutFile.write("You need " + df2.format(bricksNeeded) + " Bricks " 
                      + "to complete the project" + "\n");
              myOutPutFile.write("Total Price for your Job is:" + df2.format(priceOfProject)
              + "dollars." +"\n");
              myOutPutFile.write("Thank you for Using Our System!");
              
         }
        JOptionPane.showMessageDialog(null, "Your information has been saved "
        + "to a file");
    }
     catch (IOException e)
     {
       JOptionPane.showMessageDialog(null, "An error occured");
     }
    }
// Global Variables for bricks (width and height and area)

private static final double MODULARWIDTH = 2.25;
private static final double MODULARHEIGHT = 7.625;
public static double modularBrick = MODULARWIDTH * MODULARHEIGHT;

private static final double QUEENWIDTH = 2.75;
private static final double QUEENHEIGHT = 7.625;
public static double queenBrick = QUEENWIDTH * QUEENHEIGHT;

private static final double CLOSUREWIDTH = 3.625;
private static final double CLOSUREHEIGHT = 7.625;
public static double closureBrick = CLOSUREWIDTH * CLOSUREHEIGHT;

private static final double STANDARDWIDTH = 2.25;
private static final double STANDARDHEIGHT = 8;
public static double standardBrick = STANDARDWIDTH * STANDARDHEIGHT;

private static final double JUMBOWIDTH = 2.75;
private static final double JUMBOHEIGHT = 8;
public static double jumboBrick = JUMBOWIDTH * JUMBOHEIGHT;

private static final double KINGWIDTH = 2.625;
private static final double KINGHEIGHT = 9.625;
public static double kingBrick = KINGWIDTH * KINGHEIGHT;

private static final double ROMANWIDTH = 1.625;
private static final double ROMANHEIGHT = 11.625;
public static double romanBrick = ROMANWIDTH * ROMANHEIGHT;

private static final double NORMANWIDTH = 2.25;
private static final double NORMANHEIGHT = 11.625;
public static double normanBrick = NORMANWIDTH * NORMANHEIGHT;

private static final double UTILITYWIDTH = 3.625;
private static final double UTILITYHEIGHT = 11.625;
public static double utilityBrick = UTILITYWIDTH * UTILITYHEIGHT;

//Global FTCC Variables
private static final double FTCCSURFACEAREA = 492072;
private static final double FTCCSUBTRACTWINDOWFRAMES = 16280;
private static final double FTCCSUBTRACTCOMPUTERFRONTFRAME = 15136;
private static final double FTCCSUBTRACTDOORS = 56320;
private static final double FTCCADDADENTIONS = 21917;
private static final double FTCCADDCORNERS = 23230;

// Global Variables for the program
public static double morterSpace = 0;
public static double priceOfProject = 0;
public static double bricksNeeded= 0;
public static String personName = "";
public static String personEmail = "";
public static String personOccupation = "";
public static double personPhoneNumber = 0; 
public static double total;       
}


