/*
 * SNHU - IT145
 * Final Project - Zoo Monitoring System
 * 08/17/2017
 */
package zoomonitor;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Joseph Tooze
 */
public class ZooMonitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Create scnr, animal, and habitat objects
        Scanner scnr = new Scanner(System.in);
        MonitorAnimal animal = new MonitorAnimal();
        MonitorHabitat habitat = new MonitorHabitat();
        
        String scanChoice = "";
        char userChoice = '1';
        
        // Display main menu as long as userChoice does not equal 'q' or 'Q'
        while ((userChoice != 'Q') && (userChoice != 'q')) {
            System.out.println("");
            System.out.println("Main Menu");
            System.out.println("1. Monitor an animal");
            System.out.println("2. Monitor a habitat");
            System.out.println("Q. Quit");
            System.out.println("");
            System.out.print("Enter option: ");
            
            scanChoice = scnr.nextLine();
            
            // Checks for any input other than a single character
            if (scanChoice.length() > 1) {
                userChoice = '0';
            }
            else {
                // Assign single character input to userChoice
                userChoice = scanChoice.charAt(0);
            }
           
            // Main menu switch statement (choose animal, habitat, or q to quit)
            switch (userChoice) {
                case '1':
                    System.out.println("");
                    animal.monitorAnimal();
                    break;
                case '2':
                    System.out.println("");
                    habitat.monitorHabitat();
                    break;
                case 'Q':
                case 'q':
                    break;
                default:
                    // If any other value, display error
                    System.out.println("");
                    System.out.println("Please enter a valid option.");
                    break;
            }       
        }
    }
}