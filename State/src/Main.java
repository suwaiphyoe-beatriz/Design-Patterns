import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameCharacter character = new GameCharacter("Hero");

        while (!character.getLevelName().equals("Master")) {

            character.showStatus();

            System.out.println("\nAvailable Actions:");
            System.out.println("1 - Train");
            System.out.println("2 - Meditate");
            System.out.println("3 - Fight");
            System.out.println("Choose action:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> character.train();
                case 2 -> character.meditate();
                case 3 -> character.fight();
                default -> System.out.println("Invalid choice!");
            }
        }

        System.out.println("\nYayyyy Congratulations! You reached Master level!");
    }
}