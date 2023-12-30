import java.util.ArrayList;

public class BattleshipTester {
    public static void main(String[] args) {
        System.err.println("Testing battleship class.");

        // Create array of coordinates containing the ship's location.
        ArrayList<Coordinate> shipLocation = new ArrayList<Coordinate>();
        for (String coorStr : new String[]{"A1", "A2"}) {
            Coordinate coor = new Coordinate();
            coor.setLocation(coorStr);
            shipLocation.add(coor);
        }

        // Initiate ship and set location.
        Battleship ship = new Battleship();
        ship.setLocation(shipLocation);

        // Initiate coordinate to function as the user's chosen coordinate.
        Coordinate chosenCoor = new Coordinate();

        // Initiate result bool to store test results

        // Test 1: User missed ship.
        chosenCoor.setLocation("B1");
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
        chosenCoor.setLocation("A1");
        result = ship.checkIfHit(chosenCoor);
        if (result) {
            System.err.println("Test 3 succeeded.");
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
        chosenCoor.setLocation("A2");
        result = ship.checkIfHit(chosenCoor);
        if (result) {
            System.err.println("Test 5 succeeded.");
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
