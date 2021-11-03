
package brickblock;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
public class BrickBlock {

// Looped menu
    public static void main(String[] args) {
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
    
    private static void openIntro(){
        String name;
        
        String inOut;
        
        String occupation;
        
        JOptionPane.showMessageDialog(null, "Hello");
        
        name = JOptionPane.showInputDialog("What is your name?");
        
        JOptionPane.showMessageDialog(null, "My name is " + name);
        
        JOptionPane.showMessageDialog(null, "Hello! " + name);
        
        occupation = JOptionPane.showInputDialog("What is your occupation " + name);
        
        
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

    // use user measurements to give an average esitmate for the bricks they will need for a certain area.
    private static void userMeasurements() {
        
    }
    }
    

