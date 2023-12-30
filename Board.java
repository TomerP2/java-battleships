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
            String coorStr = hitCoor.getLocation();
            Integer realX = letterToNumber(coorStr.charAt(0));
            Integer realY = Integer.parseInt(coorStr.substring(1)) - 1;
            grid.get(realX).set(realY, "+");
        }

        // Do the same with the missCoordinates arraylist, but change the associated grid cell to "-".
        for (Coordinate missCoor : missCoordinates){
            String coorStr = missCoor.getLocation();
            Integer realX = letterToNumber(coorStr.charAt(0));
            Integer realY = Integer.parseInt(coorStr.substring(1)) - 1;
            grid.get(realX).set(realY, "-");
        }

        //Return the grid
        return grid;
    }

    private Integer letterToNumber(char letter){
        switch (letter) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            default:
                return -1;
        }
    }
}
