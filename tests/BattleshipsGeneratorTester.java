package tests;
import java.util.ArrayList;

import data_structures.Battleship;
import workers.BattleshipsGenerator;
import data_structures.Board;
import data_structures.Coordinate;
import workers.UserInteractor;

public class BattleshipsGeneratorTester {
    public static void main(String[] args) {
        for (Integer i = 0; i < 5; i++) {
            Board board = new Board();
            UserInteractor.show("Board " + i);
            ArrayList<Battleship> battleships = BattleshipsGenerator.generate();

            for (Battleship ship : battleships) {
                for (Coordinate coor : ship.getLocation()){
                    board.setCoordinateTo(coor, "hit");
                }
            }
            
            ArrayList<ArrayList<String>> grid = board.getBoardAsGrid();
            UserInteractor.showBoard(grid);
            UserInteractor.show(" ");

            //Visually confirm the ship placement looks correct a few times.
        }
    }
}
