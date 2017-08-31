/*
 * SNHU - IT145
 * Final Project - Zoo Monitoring System
 * 08/17/2017
 */
package zoomonitor;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Joseph Tooze
 */
public class MonitorAnimal {
    public void monitorAnimal() throws IOException {
        // New scanner object
        Scanner scnr = new Scanner(System.in);
        FileInputStream fileByteStream; 
        Scanner inFS;
        
        // Variable definitions
        String animalChoice;
        char charOption = '0'; 
        String menuLine1, menuLine2, menuLine3, menuLine4, menuLine5;
        String errorCheck = "";
        
        // Control loop that displays "animals" menu unless 'Q' or 'q' is entered
        while ((charOption != 'Q') && (charOption != 'q')) {
            // Opening file animals.txt
            fileByteStream = new FileInputStream("src\\zoomonitor\\animals.txt");
            inFS = new Scanner(fileByteStream);
            
            // Prints "animals" menu from file animals.txt
            int i;
            for (i=1; i <= 4; ++i) {
                System.out.println(inFS.nextLine());
            }
            System.out.println("Q. Back to main menu");
            System.out.println("");
            System.out.print("Enter animal to monitor (example: Lion): ");
            animalChoice = scnr.nextLine();
            
            // Checks to see if user choice is 'q' or 'Q'
            if (animalChoice.length() == 1) {
                charOption = animalChoice.charAt(0);
                if (charOption == 'q' || charOption == 'Q') {
                    fileByteStream.close();
                    break;
                }
                else {
                    System.out.println("");
                    System.out.println("Enter a valid option.");
                    System.out.println("");
                    continue;
                }
            }
                    
            // Control loop that checks for "alert" status
            while (inFS.hasNextLine()) {
                menuLine1 = inFS.nextLine();
                if (menuLine1.contains(animalChoice)) {
                    errorCheck = menuLine1;
                    menuLine2 = inFS.nextLine();
                    if (menuLine2.contains("*****")) {
                        menuLine2 = menuLine2.replace("*****", "");
                        openDialogBox(menuLine2);
                    }
                    menuLine3 = inFS.nextLine();
                    if (menuLine3.contains("*****")) {
                        menuLine3 = menuLine3.replace("*****", "");
                        openDialogBox(menuLine3);
                    }
                    menuLine4 = inFS.nextLine();
                    if (menuLine4.contains("*****")) {
                        menuLine4 = menuLine4.replace("*****", "");
                        openDialogBox(menuLine4);
                    }
                    menuLine5 = inFS.nextLine();
                    if (menuLine5.contains("*****")) {
                        menuLine5 = menuLine5.replace("*****", "");
                        openDialogBox(menuLine5);
                    }
                    
                    // Display monitored animal information
                    System.out.println("");
                    System.out.println(menuLine1);
                    System.out.println(menuLine2);
                    System.out.println(menuLine3);
                    System.out.println(menuLine4);
                    System.out.println(menuLine5);
                    System.out.println("");
                    

                }
            }
        // Checks whether a valid animal choice has been made    
        if (!errorCheck.contains(animalChoice)) {
            System.out.println("");
            System.out.println("Enter a valid option.");
            System.out.println("");
        }
        // Closing file animals.txt    
        fileByteStream.close();
        }
        return;
    }
    
    // Method to open dialog box upon "alert"
    public void openDialogBox(String msg) {
       JOptionPane.showMessageDialog(null, msg, "Health Issue", JOptionPane.INFORMATION_MESSAGE);
       return;
    }
}
