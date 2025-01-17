package FlightControl.ui;

import FlightControl.domain.Flight;
import FlightControl.domain.Airplane;
import FlightControl.logic.FlightControl;
import java.util.Scanner;


/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class TextUI {
    private FlightControl flightControl;
    private Scanner scanner;
    
    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }
    
    public void start() {
        startAssetControl();
        System.out.println();
        startFlightControl();
        System.out.println();
    }
    
    private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();
        
        OUTER:
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");
            
            String command = scanner.nextLine();            
            switch (command) {
                case "1":
                    addAirplane();
                    break;                       
                case "2":
                    addFlight();
                    break;                      
                case "x":
                    break OUTER;
            }
        }
    }
    
    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String planeID = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        flightControl.addAirplane(planeID, capacity);
    }
    
    private void addFlight() {
        System.out.print("Give the airplane id: ");
        Airplane airplane = this.askForAirplane();
        System.out.print("Give the departure airport id: ");
        String departureID = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String targetID = scanner.nextLine();
                    
        flightControl.addFlight(airplane, departureID, targetID);
    }
    
    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        OUTER:
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");
            
            String command = scanner.nextLine();            
            switch (command) {
                case "1":
                    printAirplanes();
                    break;                       
                case "2":
                    printFlights();
                    break; 
                case "3":
                    printAirplaneDetails();
                    break;  
                case "x":
                    break OUTER;
            }
        }
    }
    
    private void printAirplanes() {
        for (Airplane plane: flightControl.getAirplanes()) {
            System.out.println(plane);
        }
    }
    
    private void printFlights() {
        for (Flight flight: flightControl.getFlights()) {
            System.out.println(flight);
        }
    }
    
    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.println(plane);
        System.out.println();
    }
    
    private Airplane askForAirplane() {
        Airplane airplane = null;
        while (airplane == null) {
            String ID = scanner.nextLine();
            airplane = flightControl.getAirplane(ID);
            
            if (airplane == null) {
                System.out.println("No airplane with the id " + ID + ".");
            }
        }
        return airplane;
    }
}
