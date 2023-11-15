import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to TicTacToe!");
        System.out.println("######################################");
        System.out.println(" ");
        System.out.println("Enter board dimension:");

        Scanner sc = new Scanner(System.in);
        int dim = sc.nextInt();
        Board gameBoard = new Board(dim);

        System.out.println("######################################");
        System.out.println(" ");
        System.out.println("Enter Player 1 Name:");
        String name1 = sc.next();
        System.out.println(" ");
        System.out.println("Enter Player 1 Age:");
        int age1 = sc.nextInt();

        Player player1 = new Player(name1, age1, Mark.Player1);

        System.out.println("######################################");
        System.out.println(" ");
        System.out.println("Enter Player 2 Name:");
        String name2 = sc.next();
        System.out.println(" ");
        System.out.println("Enter Player 2 Age:");
        int age2 = sc.nextInt();

        Player player2 = new Player(name2, age2, Mark.Player2);

        System.out.println("######################################");
        System.out.println(" ");
        System.out.println("Start game? (y/n)");
        String start = sc.next().toLowerCase();
        if(start.equals("y")) {
            Game newGame = new Game(gameBoard);
            newGame.addPlayer(player1);
            newGame.addPlayer(player2);
            newGame.playGame();
        }

    }
}