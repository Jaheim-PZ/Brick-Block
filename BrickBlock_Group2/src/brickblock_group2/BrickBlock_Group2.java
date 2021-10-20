/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickblock_group2;

import javax.swing.JOptionPane;


public class BrickBlock_Group2 {

public static double brickLength = 0;
public static double brickWidth = 0;
public static double morterSpace = 0; 
public static String personName = "";
public static String personEmail = "";
public static String personOccupation = "";
public static double personPhoneNumber = 0; 

    public static void main(String[] args) {
        // TODO code application logic here
    }
 public static void brickArea()
 {
  
 }
 public static void personalInformation()
 {
  
  personName = JOptionPane.showInputDialog("What is your Name:");
  personEmail = JOptionPane.showInputDialog("What is your Email:");
  personOccupation = JOptionPane.showInputDialog("What is your Occupation:");  
  personPhoneNumber = Double.parseDouble(JOptionPane.showInputDialog
       (null, "What is your Phone Number:"));
 
 }
}
