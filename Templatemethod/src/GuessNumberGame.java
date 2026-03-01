import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame extends Game {

    private int numberOfPlayers;
    private int secretNumber;
    private boolean gameEnded;
    private int winner;
    private Scanner scanner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.gameEnded = false;
        this.winner = -1;

        Random random = new Random();
        secretNumber = random.nextInt(100) + 1; // 1–100

        scanner = new Scanner(System.in);

        System.out.println("Guess The Number Game Started!");
        System.out.println("Players: " + numberOfPlayers);
        System.out.println("Guess a number between 1 and 100.");
    }

    @Override
    public boolean endOfGame() {
        return gameEnded;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Player " + (player + 1) + ", enter your guess:");

        int guess = scanner.nextInt();

        if (guess == secretNumber) {
            System.out.println("Correct!");
            winner = player + 1;
            gameEnded = true;
        } else if (guess < secretNumber) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Game Over!");
        System.out.println("Player " + winner + " wins!");
    }
}