import java.util.ArrayList;
import java.util.Iterator;

import data_structures.Battleship;
import data_structures.Board;
import data_structures.Coordinate;
import workers.BattleshipsGenerator;
import workers.UserInteractor;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<Battleship> battleships = BattleshipsGenerator.generate();
        Board board = new Board();
        Integer tries = 0;
        Integer aliveShips = 3;

        UserInteractor.show("Welcome to battleships!");
        UserInteractor.show("The computer has generated three ships, sizes 2 to 4.");
        UserInteractor.show("It's your job to destroy them all!");
        UserInteractor.show("The board follows chess notations, so A1 is the bottom left cell and G7 is the top right cell.");
        UserInteractor.show("Simply type in your chosen cell to shoot at it! Good luck!");

        while (true){
            Coordinate chosenCoor = UserInteractor.getValidInputCoor("Choose a cell: ");
            tries++;
            Boolean hit = false;

            Iterator<Battleship> iterator = battleships.iterator();
            while (iterator.hasNext()) {
                Battleship ship = iterator.next();
                if (!ship.checkIfHit(chosenCoor)) {
                    continue;
                }

                hit = true;
                ship.reduceHealth();

                if (ship.checkIfDead()) {
                    UserInteractor.show("You destroyed a ship!");
                    aliveShips--;
                    iterator.remove();
                }
            }

            if (hit) {
                board.setCoordinateTo(chosenCoor, "hit");
                UserInteractor.show("Hit!");
            } else {
                board.setCoordinateTo(chosenCoor, "miss");
                UserInteractor.show("Miss.");
            }

            if (aliveShips == 0) {
                UserInteractor.show("Congratz! You win. Took you only " + tries + "shots." );
                return;
            }

            UserInteractor.showBoard(board.getBoardAsGrid());
        }
    }
}