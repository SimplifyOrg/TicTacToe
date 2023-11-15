import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private WinningStrategy winChecker;
    private final Board gameBoard;
    private boolean isFinished = false;
    private Mark nextMove = Mark.Player1;
    private boolean isGameStarted = false;
    private Player winner;
    private ArrayList<Player> players;

    public Game(Board gameBoard) {
        this.gameBoard = gameBoard;
        winChecker = new CrissCrossWinningStrategy(gameBoard);
    }

    public void setWinChecker(WinningStrategy winChecker) {
        if(this.isGameStarted) {
            //Throw exception
            System.out.println("Game started cannot change winning strategy!");
            return;
        }
        this.winChecker = winChecker;
    }

    public void addPlayer(Player player){
        if(players == null) {
            players = new ArrayList<Player>();
        }
        if(players.size() >= 2) {
            //Throw exception
            System.out.println("All the player spots occupied!");
            return;
        }
        players.add(player);
    }

    public void playGame(){
        this.isGameStarted = true;
        while(!isFinished()) {
            gameBoard.display();
            if(nextMove == Mark.Player1) {
                makeMove(0);
                nextMove = Mark.Player2;
            }
            else {
                makeMove(1);
                nextMove = Mark.Player1;
            }

            Mark winner = winChecker.findWinner();

            if(winner == Mark.None && checkFinished()) {
                isFinished = true;
                System.out.println("Game tied!");
            }
            else if(winner == Mark.Player1){
                isFinished = true;
                System.out.println(players.get(0).getName() + " won!");
            }
            else if(winner == Mark.Player2){
                isFinished = true;
                System.out.println(players.get(1).getName() + " won!");
            }
        }
    }

    public boolean isFinished() {
        return isFinished;
    }

    private void makeMove(int playerIndex){
        System.out.println(" ");
        System.out.println(players.get(playerIndex).getName() + " to move!");
        System.out.println("Enter move as (row,col):");
        Scanner sc = new Scanner(System.in);
        String move = sc.next();
        String[] moveList = move.split(",");
        int row = Integer.parseInt(moveList[0]);
        int col = Integer.parseInt(moveList[1]);
        gameBoard.setPlayerInCell(row, col, players.get(playerIndex));
    }

    private boolean checkFinished(){
        return gameBoard.isAllOccupied();
    }
}
