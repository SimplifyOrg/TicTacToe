import java.util.ArrayList;

public class CrissCrossWinningStrategy implements WinningStrategy{
    private final Board gameBoard;
    public Mark findWinner() {
        // Check the winner and return the mark
        Mark rowWinner = checkRows();
        if(rowWinner != Mark.None){
            return rowWinner;
        }
        Mark colWinner = checkCols();
        if(colWinner != Mark.None){
            return colWinner;
        }
        return checkDiagonals();
    }

    public CrissCrossWinningStrategy(Board gameBoard){
        this.gameBoard = gameBoard;
    }

    private Mark checkRows(){
        Mark currentOccupied = Mark.None;
        for(ArrayList<Cell> row : this.gameBoard.getCellArrangement()){
            boolean win = true;
            for(Cell cell: row){
                if(cell.getOccupiedBy() == null){
                    win = false;
                    break;
                }
                if(currentOccupied == Mark.None){
                    currentOccupied = cell.getOccupiedBy().getPlayerType();
                }

                if(currentOccupied != cell.getOccupiedBy().getPlayerType()){
                    win = false;
                    break;
                }
            }
            if(win){
                return currentOccupied;
            }
        }
        return Mark.None;
    }

    private Mark checkCols(){
        Mark currentOccupied = Mark.None;
        for(int col = 0; col < this.gameBoard.getCellArrangement().get(0).size(); ++col){
            boolean win = true;
            for(ArrayList<Cell> row : this.gameBoard.getCellArrangement()){
                if(row.get(col).getOccupiedBy() == null){
                    win = false;
                    break;
                }
                if(currentOccupied == Mark.None){
                    currentOccupied = row.get(col).getOccupiedBy().getPlayerType();
                }

                if(currentOccupied != row.get(col).getOccupiedBy().getPlayerType()){
                    win = false;
                    break;
                }
            }
            if(win){
                return currentOccupied;
            }
        }
        return Mark.None;
    }

    private Mark checkDiagonals(){
        Mark currentOccupied = Mark.None;
        for(int row = 0, col = 0; row < this.gameBoard.getCellArrangement().size()
                                    && col < this.gameBoard.getCellArrangement().get(0).size() ; ++row, ++col) {
            if(this.gameBoard.getCellArrangement().get(row).get(col).getOccupiedBy() == null){
                return Mark.None;
            }

            if(currentOccupied == Mark.None){
                currentOccupied = this.gameBoard.getCellArrangement().get(row).get(col).getOccupiedBy().getPlayerType();
            }

            if(currentOccupied != this.gameBoard.getCellArrangement().get(row).get(col).getOccupiedBy().getPlayerType()){
                return Mark.None;
            }
        }

        for(int row = 0, col = this.gameBoard.getCellArrangement().get(0).size()-1; row < this.gameBoard.getCellArrangement().size()
                && col >= 0 ; ++row, --col) {
            if(this.gameBoard.getCellArrangement().get(row).get(col).getOccupiedBy() == null){
                return Mark.None;
            }

            if(currentOccupied == Mark.None){
                currentOccupied = this.gameBoard.getCellArrangement().get(row).get(col).getOccupiedBy().getPlayerType();
            }

            if(currentOccupied != this.gameBoard.getCellArrangement().get(row).get(col).getOccupiedBy().getPlayerType()){
                return Mark.None;
            }
        }

        return currentOccupied;
    }
}
