import java.util.ArrayList;

public class BattleshipsGeneratorTester {
    public static void main(String[] args) {
        UserInteractor interactor = new UserInteractor();
        
        for (Integer i = 0; i < 5; i++) {
            Board board = new Board();
            interactor.show("Board " + i);
            ArrayList<Battleship> battleships = BattleshipsGenerator.generate();

            for (Battleship ship : battleships) {
                for (Coordinate coor : ship.getLocation()){
                    board.setCoordinateTo(coor, "hit");
                }
            }
            
            ArrayList<ArrayList<String>> grid = board.getBoardAsGrid();
            interactor.showBoard(grid);
            interactor.show(" ");

            //Visually confirm the ship placement looks correct a few times.
        }
    }
}
