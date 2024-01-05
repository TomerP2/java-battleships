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
        UserInteractor interactor = new UserInteractor();
        Integer tries = 0;
        Integer shipsAlive = 3;

        interactor.show("Welcome to battleships!");
        interactor.show("The computer has generated three ships, sizes 2 to 4.");
        interactor.show("It's your job to destroy them all!");
        interactor.show("The board follows chess notations, so A1 is the bottom left cell and G7 is the top right cell.");
        interactor.show("Simply type in your chosen cell to shoot at it! Good luck!");

        while (true){
            Coordinate chosenCoor = interactor.getValidInputCoor("Choose a cell: ");
            tries++;
            Boolean hit = false;

            Iterator<Battleship> iterator = battleships.iterator();
            while (iterator.hasNext()) {
                Battleship ship = iterator.next();
                if (!ship.checkIfHit(chosenCoor)) {
                    continue;
                }

                hit = true;
                if (ship.checkIfDead()) {
                    interactor.show("You destroyed a ship!");
                    shipsAlive--;
                    iterator.remove();
                }
            }

            if (hit) {
                board.setCoordinateTo(chosenCoor, "hit");
                interactor.show("Hit!");
            } else {
                board.setCoordinateTo(chosenCoor, "miss");
                interactor.show("Miss.");
            }

            if (shipsAlive == 0) {
                interactor.show("Congratz! You win. Took you only " + tries + "shots." );
                return;
            }

            interactor.showBoard(board.getBoardAsGrid());
        }
    }
}