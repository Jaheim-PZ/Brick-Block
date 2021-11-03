/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickblock_group2;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class BrickBlock_Group2 {

private static final double BRICKDEPTH = 3.625;
private static final double BRICKWIDTH = 2.25;
private static final double BRICKHEIGHT = 7.625;
public static double modularBrick = BRICKDEPTH * BRICKWIDTH * BRICKHEIGHT; 
public static double morterSpace = 0; 
public static String personName = "";
public static String personEmail = "";
public static String personOccupation = "";
public static double personPhoneNumber = 0; 

    public static void main(String[] args) 
    {   
 
     fullProgramMenu();
    }

  private static void openIntro()
     {
        JOptionPane.showMessageDialog(null, "Hello");

        personName = JOptionPane.showInputDialog("What is your name?");

        JOptionPane.showMessageDialog(null, "My name is " + personName);

        JOptionPane.showMessageDialog(null, "Hello! " + personName);

        personOccupation = JOptionPane.showInputDialog("What is your occupation " + personOccupation);
     }
 public static void endingGreeting()
 {
 
 }

 public static void personalInformation()
 {
  
  //personName = JOptionPane.showInputDialog("What is your Name:");
  personEmail = JOptionPane.showInputDialog("What is your Email:");
  //personOccupation = JOptionPane.showInputDialog("What is your Occupation:");  
  personPhoneNumber = Double.parseDouble(JOptionPane.showInputDialog
       (null, "What is your Phone Number:"));
 
 }

 // Looped menu
    private static void fullProgramMenu()
    {  
     openIntro();
     personalInformation();   
        
    String[] choices = {"1. BrickBlock ", "2. Personal Measurements ", 
                    "3. Price calculator", "4. Quit"};

String menu = "";
while (!menu.equals("4. Quit")) {
    menu = (String) JOptionPane.showInputDialog(null, "<html>Choose A Menu Item:<br><br></html>", "Main Menu", 
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
    if (menu == null) {
        break; 
    }

    switch (menu) {
        case "1. BrickBlock ":
             project();
            break;
        case "2. Personal Measurements ":
              userinput();
            break;
        case "3. Price calculator":
            calculator();
            break;
        case "4. Quit":           
            break;
        }
    }
    }

    // this is where all the guts of the main project will go
    private static void project() {
        //Main project
        // Must be done first. - main prio
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
        
    }
       private static void userMeasurements() {
           
           //I WANT TO CHANGE
        
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
}

 

