public class Coordinate {
    Integer x;
    Integer y;

    public void setLocation(Integer new_x, Integer new_y) {
        if (x < 1 || x > 7){
            throw new IllegalArgumentException("Error: The x value '" + x + "' is not a valid value");
        }
        
        if (y < 1 || y > 7){
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
        return x.equals(otherCoordinate.x) && y.equals(otherCoordinate.y);
    }
}
