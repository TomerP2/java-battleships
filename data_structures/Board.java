package data_structures;
import java.util.ArrayList;

public class Board {
    ArrayList<Coordinate> hitCoordinates = new ArrayList<Coordinate>();
    ArrayList<Coordinate> missCoordinates = new ArrayList<Coordinate>();;

    public void setCoordinateTo( Coordinate coor, String state){
        switch (state) {
            case "hit":
                hitCoordinates.add(coor);
                break;
        
            case "miss":
                missCoordinates.add(coor);
                break;
        }
    }

    public ArrayList<ArrayList<String>> getBoardAsGrid() {
        // Create a 7x7 grid where all the values are empty strings (" ").
        ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
        for (int x = 0; x <= 6; x++){
            ArrayList<String> row = new ArrayList<String>();
            for (int y = 0; y <= 6; y++){
                row.add(" ");
            }
            grid.add(row);
        }

        // For each coordinate in the hitCoordinates arraylist, change the associated grid cell to "+".
        for (Coordinate hitCoor : hitCoordinates){
            Integer[] coordinates = hitCoor.getLocation();
            Integer x = coordinates[0];
            Integer y = coordinates[1];
            grid.get(x).set(y, "+");
        }

        // Do the same with the missCoordinates arraylist, but change the associated grid cell to "-".
        for (Coordinate missCoor : missCoordinates){
            Integer[] coordinates = missCoor.getLocation();
            Integer x = coordinates[0];
            Integer y = coordinates[1];
            grid.get(x).set(y, "-");
        }

        //Return the grid
        return grid;
    }
}
