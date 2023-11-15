public class Cell {
    private int row;
    private int col;
    private Player occupiedBy;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setOccupiedBy(Player player) {
        if(this.occupiedBy != null) {
            //throw exception
            return;
        }
        this.occupiedBy = player;
    }

    public Player getOccupiedBy() {
        return occupiedBy;
    }
}
