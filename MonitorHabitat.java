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
public class MonitorHabitat {
    public void monitorHabitat() throws IOException {
        // New scanner object
        Scanner scnr = new Scanner(System.in);
        FileInputStream fileByteStream; 
        Scanner inFS;
        
        // Variable definitions
        String habitatChoice;
        char charOption = '0'; 
        String menuLine1, menuLine2, menuLine3, menuLine4;
        String errorCheck = "";
        
        // Control loop that displays "habitats" menu unless 'Q' or 'q' is entered
        while ((charOption != 'Q') && (charOption != 'q')) {
            // Opening file habitats.txt
            fileByteStream = new FileInputStream("src\\zoomonitor\\habitats.txt");
            inFS = new Scanner(fileByteStream);
            
            // Prints "habitats" menu from file habitats.txt
            int i;
            for (i=1; i <= 4; ++i) {
                System.out.println(inFS.nextLine());
            }
            System.out.println("Q. Back to main menu");
            System.out.println("");
            System.out.print("Enter habitat to monitor (Penguin, Bird, or Aquarium): ");
            habitatChoice = scnr.nextLine();
            
            // Checks to see if user choice is 'q' or 'Q'
            if (habitatChoice.length() == 1) {
                charOption = habitatChoice.charAt(0);
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
                if (menuLine1.contains(habitatChoice)) {
                    errorCheck = menuLine1;
                    menuLine2 = inFS.nextLine();
                    if (menuLine2.contains("*****")) {
                        menuLine2 = menuLine1.replace("*****", "");
                        openDialogBox(menuLine1);
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
                    
                    // Display monitored habitat information
                    System.out.println("");
                    System.out.println(menuLine1);
                    System.out.println(menuLine2);
                    System.out.println(menuLine3);
                    System.out.println(menuLine4);
                    System.out.println("");
                    

                }
            }
        // Checks whether a valid habitat choice has been made    
        if (!errorCheck.contains(habitatChoice)) {
            System.out.println("");
            System.out.println("Enter a valid option.");
            System.out.println("");
        }
        // Closing file habitats.txt    
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