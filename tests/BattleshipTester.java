package tests;
import java.util.ArrayList;

import data_structures.Battleship;
import data_structures.Coordinate;

public class BattleshipTester {
    public static void main(String[] args) {
        System.err.println("Testing battleship class.");

        // Create array of coordinates containing the ship's location.
        ArrayList<Coordinate> shipCoor = new ArrayList<Coordinate>();

        Coordinate coor1 = new Coordinate(0, 0);
        shipCoor.add(coor1);
        
        Coordinate coor2 = new Coordinate(0, 1);
        shipCoor.add(coor2);
        
        // Initiate ship and set location.
        Battleship ship = new Battleship(shipCoor);
        
        // Test 1: User missed ship.
        Coordinate chosenCoor = new Coordinate(1, 0);
        Boolean result = ship.checkIfHit(chosenCoor);
        if (result) {
            System.out.println("Test 1 failed.");
        } else {
            System.out.println("Test 1 succeeded.");
        }

        // Test 2: Ship should still be alive. 
        result = ship.checkIfDead();
        if (!result) {
            System.err.println("Test 2 succeeded.");
        } else {
            System.err.println("Test 2 failed.");
        }

        // Test 3: User hits ship first time.
        chosenCoor = new Coordinate(0, 0);
        result = ship.checkIfHit(chosenCoor);
        if (result) {
            System.err.println("Test 3 succeeded.");
            ship.reduceHealth();
        } else {
            System.err.println("Test 3 failed.");
        }

        // Test 4: Ship should still be alive. 
        result = ship.checkIfDead();
        if (!result) {
            System.err.println("Test 4 succeeded.");
        } else {
            System.err.println("Test 4 failed.");
        }

        // Test 5: User hits ship second time. 
        chosenCoor = new Coordinate(0, 1);
        result = ship.checkIfHit(chosenCoor);
        if (result) {
            System.err.println("Test 5 succeeded.");
            ship.reduceHealth();
        } else {
            System.err.println("Test 5 failed.");
        }

        // Test 6: Ship should be dead. 
        result = ship.checkIfDead();
        if (result) {
            System.err.println("Test 6 succeeded.");
        } else {
            System.err.println("Test 6 failed.");
        }
    }
}
