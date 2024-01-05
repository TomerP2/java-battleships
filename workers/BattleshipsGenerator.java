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
                Coordinate firstCoor = new Coordinate(x, y);
                shipCoors.add(firstCoor);

                // Loop through 'length' times. Try to create cells above or to the right of the first coordinate. 
                try{
                    for (int n = 1; n < length; n++){
                        if (horizontal) {
                            // If horizontal, try to create a new cell to the right of the last created cell. 
                            Coordinate coor = new Coordinate(x + n, y);
                            shipCoors.add(coor);
                        } else {
                            // If vertical, try to create a new cell to the top of the last created cell. 
                            Coordinate coor = new Coordinate(x, y + n);
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

            for(Coordinate shipCoor : shipCoors){
                // Add created coordinates to occupiedCoordinates array.
                occupiedCoors.add(shipCoor);
                
                // Also add coordinates horizontally, vertically or diagonally adjacent to shipCoordinate, to prevent adjacent placements.
                Integer[] shipLocation = shipCoor.getLocation();
                Integer x = shipLocation[0];
                Integer y = shipLocation[1];

                tryToAddCoordinateTo(occupiedCoors, x + 1, y); //Right
                tryToAddCoordinateTo(occupiedCoors, x - 1, y); //Left
                tryToAddCoordinateTo(occupiedCoors, x, y + 1); //Top
                tryToAddCoordinateTo(occupiedCoors, x, y - 1); //Bottom
                tryToAddCoordinateTo(occupiedCoors, x + 1, y + 1); //Top-right
                tryToAddCoordinateTo(occupiedCoors, x + 1, y - 1); //Bottom-right
                tryToAddCoordinateTo(occupiedCoors, x - 1, y + 1); //Top-left
                tryToAddCoordinateTo(occupiedCoors, x - 1, y + 1); //Bottom-left
            }
        }
        return battleships;
    }

    private static void tryToAddCoordinateTo(ArrayList<Coordinate> list, Integer x, Integer y){
        try{
            list.add(new Coordinate(x, y));
        } catch (IllegalArgumentException e) {
            // Means the coordinate is outside the game area, skip it    
        }
    }
}

