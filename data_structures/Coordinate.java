package data_structures;
public class Coordinate {
    Integer x;
    Integer y;

    public Coordinate(Integer new_x, Integer new_y){
        if (new_x < 0 || new_x > 6){
            throw new IllegalArgumentException("Error: The x value '" + x + "' is not a valid value");
        }
        
        if (new_y < 0 || new_y > 6){
            throw new IllegalArgumentException("Error: The y value '" + y + "' is not a valid value");
        }
    
        x = new_x;
        y = new_y;
    }

    public Integer[] getLocation() {
        return new Integer[]{x, y};
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Coordinate otherCoordinate = (Coordinate) obj;
        return (x == otherCoordinate.x && y == otherCoordinate.y);
    }
}
