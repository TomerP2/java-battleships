package workers;
import java.util.ArrayList;
import java.util.Random;

import data_structures.Battleship;
import data_structures.Coordinate;

public class BattleshipsGenerator {
    public static ArrayList<Battleship> generate() {
        ArrayList<Battleship> battleships = new ArrayList<Battleship>();
        ArrayList<Coordinate> occupiedCoors = new ArrayList<Coordinate>();
        Random random = new Random();

        for (int i = 0; i < 3; i++){
            boolean horizontal = random.nextInt(2) == 1;
            Integer length = random.nextInt(3) + 2;
            ArrayList<Coordinate> shipCoors = new ArrayList<Coordinate>(); 

            Boolean shipIsValid = false;
            while (!shipIsValid){
                shipCoors = new ArrayList<Coordinate>(); 
                shipIsValid = true;

                // Create first coordinate. This is the startpoint of the ship's coordinates
                Integer x = random.nextInt(7);
                Integer y = random.nextInt(7);
                Coordinate firstCoor = new Coordinate();
                firstCoor.setLocation(x, y);

                shipCoors.add(firstCoor);

                // Loop through 'length' times. Try to create cells above or to the right of the first coordinate. 
                try{
                    for (int n = 1; n < length; n++){
                        Coordinate coor = new Coordinate();
                        if (horizontal) {
                            // If horizontal, try to create a new cell to the right of the last created cell. 
                            coor.setLocation(x + n, y);
                            shipCoors.add(coor);
                        } else {
                            // If vertical, try to create a new cell to the top of the last created cell. 
                            coor.setLocation(x, y + n);
                            shipCoors.add(coor);
                        }
                    }
                } catch (IllegalArgumentException e) {
                    shipIsValid = false;
                    continue;
                }

                // Check if any of the new cells are already occupied.
                for(Coordinate newCoor : shipCoors) {
                    for (Coordinate occupiedCoor : occupiedCoors) {
                        if (newCoor.equals(occupiedCoor)) {
                            shipIsValid = false;
                        }
                    }
                }
            }

            // Create a new ship and add to battleships array
            Battleship ship = new Battleship(shipCoors);
            battleships.add(ship);

            // Add created coordinates to occupiedCoordinates array
            for(Coordinate coor : shipCoors){
                occupiedCoors.add(coor);
            }
        }
        return battleships;
    }
}

