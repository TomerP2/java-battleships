import java.util.ArrayList;
import java.util.Scanner;

public class UserInteractor {
    private Scanner scanner;

    public UserInteractor() {
        this.scanner = new Scanner(System.in);
    }

    public void show(String prompt) {
        System.out.println(prompt);
    }

    public void showBoard(ArrayList<ArrayList<String>> grid) {
        show("-----------------------------");
        String line = new String();
        for (ArrayList<String> row : grid){
            line = "| ";
            for (String coor: row) {
                line = line + coor + " | ";
            }
            show(line);
            show("-----------------------------");
        }
    }

    public String getInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
}