package workers;
import java.util.ArrayList;
import java.util.Scanner;

import data_structures.Coordinate;

public class UserInteractor {
    static final Scanner scanner = new Scanner(System.in);

    private UserInteractor() {
    }

    public static void show(String prompt) {
        System.out.println(prompt);
    }

    public static void showBoard(ArrayList<ArrayList<String>> grid) {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G"};

        show("  -----------------------------");
        String line = new String();

        for (int i = 0; i <= 6; i++){
            // show each game row
            ArrayList<String> row = grid.get(i);
            int row_num = 7 - i;

            line = row_num + " | ";
            for (String coor: row) {
                line = line + coor + " | ";
            }
            
            show(line);
            show("  -----------------------------");
        }

        line = "  | ";
        for (String l : letters) {
            // Show letters underneath gameboard
            line = line + l + " | ";
        }
        show(line);
    }

    public static String getInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }

    public static Coordinate getValidInputCoor(String prompt) {
        while (true) {
            try {
                String inputstr = getInput(prompt);
                if (inputstr.length() != 2) {
                    throw new IllegalArgumentException("Invalid input format. Please enter two characters.");
                }
    
                char xchar = Character.toUpperCase(inputstr.charAt(0));
                char ychar = inputstr.charAt(1);
    
                int x = letterToNumber(xchar);
                // 'flip' the number so that input '1' is the bottom of the board, like in chess.
                int y = 7 - Character.getNumericValue(ychar); 
    
                Coordinate coor = new Coordinate(x ,y);
                return coor;
            } catch (IllegalArgumentException e) {
                show("Invalid input. Try again!");
            }
        }
    }

    private static Integer letterToNumber(char letter){
        switch (letter) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            default:
                return -1;
        }
    }
}