import java.util.ArrayList;

public class Battleship {
    ArrayList<Coordinate> locationCoors;
    Integer health;

    public void setLocation(ArrayList<Coordinate> coors){
        locationCoors = coors;
        health = locationCoors.size();
    };

    public Boolean checkIfHit( Coordinate chosenCoor ){
        for (Coordinate coor: locationCoors) {
            if (coor.equals(chosenCoor)){
                health--;
                return true;
            };
        }
        return false;
    }

    public Boolean checkIfDead(){
        return health == 0;
    }
}
