import java.util.ArrayList;
import java.util.Random;

public class Main {
    ArrayList<Battleship> battleships = new ArrayList<Battleship>();
    Board board = new Board();
    UserInteractor userInteractor = new UserInteractor();
    Integer tries = 0;

    public static void main(String[] args) {
        
    }

    private ArrayList<Battleship> generateBattleships(){
        ArrayList<Battleship> battleships = new ArrayList<Battleship>();
        ArrayList<Coordinate> OccupiedCoordinates = new ArrayList<Coordinate>();
        Random random = new Random();

        for (int i = 0; i <= 3; i++){
            boolean horizontal = random.nextInt(2) == 1;
            Integer length = random.nextInt(3) + 2;
            boolean battleShipCreated = false;

            while (!battleShipCreated){
                Integer randomX = random.nextInt(7);
                Integer randomY = random.nextInt(7);
                Coordinate firstCoordinate = new Coordinate();
                firstCoordinate.setLocation(String.valueOf(randomX) + String.valueOf(randomY));
            }

        }
    }
}