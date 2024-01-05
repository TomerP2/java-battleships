package data_structures;
import java.util.ArrayList;

public class Battleship {
    private ArrayList<Coordinate> locationCoors;
    private Integer health;

    public void setLocation(ArrayList<Coordinate> coors){
        locationCoors = coors;
        health = locationCoors.size();
    };
    
    public ArrayList<Coordinate> getLocation(){
        return locationCoors;
    }

    public Boolean checkIfHit( Coordinate chosenCoor ){
        for (Coordinate coor: locationCoors) {
            if (coor.equals(chosenCoor)){
                return true;
            };
        }
        return false;
    }

    public void reduceHealth(){
        health--;
    }

    public Boolean checkIfDead(){
        return health == 0;
    }
}
