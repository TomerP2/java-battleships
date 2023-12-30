import java.util.Arrays;

public class Coordinate {
    String coordinateString;

    public void setLocation( String location ) {
        char x = location.charAt(0);
        char y = location.charAt(1);

        Character[] validXvalues = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Character[] validYvalues = {'1', '2', '3', '4', '5', '6', '7'};

        if (!Arrays.asList(validXvalues).contains(x)){
            throw new IllegalArgumentException("Error: The x value '" + x + "' is not a valid value");
        }
        
        if (!Arrays.asList(validYvalues).contains(y)){
            throw new IllegalArgumentException("Error: The y value '" + y + "' is not a valid value");
        }

        coordinateString = location;
    }

    public String getLocation() {
        return coordinateString;
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
        return coordinateString.equals(otherCoordinate.coordinateString);
    }
}
