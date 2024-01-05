package tests;
import java.util.ArrayList;

import data_structures.Board;
import data_structures.Coordinate;

public class BoardTester {
    public static void main(String[] args) {
        // Initialize new board
        Board board = new Board();

        // Initialize result bool
        Boolean result = true;

        // Initialize grid
        ArrayList<ArrayList<String>> grid = board.getBoardAsGrid();

        // Test 1: Check if grid gets created corretly.
        for (ArrayList<String> row: grid){
            for (String coor: row) {
                if (!coor.equals(" ")) {
                    result = false;
                }
            }
        }
        if (result){
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed");
        }

        // Test 2: Check if cells get marked correctly in grid
        Coordinate hitCoor = new Coordinate();
        hitCoor.setLocation(0, 0);

        board.setCoordinateTo(hitCoor, "hit");
        grid = board.getBoardAsGrid();
        if (grid.get(0).get(0).equals("+")){
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed");
        }
    }
}
