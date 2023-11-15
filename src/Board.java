import java.util.ArrayList;

public class Board {
    private int dimension = 0;
    private ArrayList<ArrayList<Cell>> cellArrangement;

    public Board(int dim) {
        this.dimension = dim;
        cellArrangement = new ArrayList<ArrayList<Cell>>();
        for(int row = 0; row < dimension; ++row) {
            cellArrangement.add(new ArrayList<Cell>());
            for(int col = 0; col < dimension; ++col) {
                cellArrangement.get(row).add(new Cell(row, col));
            }
        }
    }

    public void display() {
        System.out.println("------");
        for (ArrayList<Cell> cells : cellArrangement) {
            for (int col = 0; col < cellArrangement.get(0).size(); ++col) {
                String cellMark = "X";
                if(cells.get(col).getOccupiedBy() == null){
                    cellMark = " ";
                }
                else if (cells.get(col).getOccupiedBy().getPlayerType().equals(Mark.Player2)) {
                    cellMark = "O";
                }
                System.out.print("|" + cellMark);
            }
            System.out.println("|");
        }

        System.out.println("------");
    }

    public void setPlayerInCell(int row, int col, Player player) {
        cellArrangement.get(row).get(col).setOccupiedBy(player);
    }

    public boolean isAllOccupied(){
        for (ArrayList<Cell> cells : cellArrangement) {
            for (int col = 0; col < cellArrangement.get(0).size(); ++col) {
                if (cells.get(col).getOccupiedBy() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getDimension() {
        return dimension;
    }

    public ArrayList<ArrayList<Cell>> getCellArrangement() {
        return cellArrangement;
    }
}
