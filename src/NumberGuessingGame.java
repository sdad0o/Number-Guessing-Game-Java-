import java.util.Scanner;

public class NumberGuessingGame {
    private final Scanner scanner = new Scanner(System.in);
    private short goal;
    private short chances;

    public void start() {
        goal = generateNumber();
        selectDifficulty();
        playGuessing();
        askToPlayAgain();
    }

    private short generateNumber() {
        return (short) (Math.random() * 100 + 1);  // avoid 0
    }

    private void selectDifficulty() {
        System.out.println("Guess the number (1-100)!");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.print("Enter your choice: ");

        while (true) {
            short choice = scanner.nextShort();
            switch (choice) {
                case 1:
                    chances = 10;
                    System.out.println("You selected Easy difficulty.");
                    return;
                case 2:
                    chances = 5;
                    System.out.println("You selected Medium difficulty.");
                    return;
                case 3:
                    chances = 3;
                    System.out.println("You selected Hard difficulty.");
                    return;
                default:
                    System.out.print("Invalid input. Enter choice (1-3): ");
            }
        }
    }

    private void playGuessing() {
        System.out.println("Let's begin!");
        for (int i = 0; i < chances; i++) {
            System.out.print("Attempt " + (i + 1) + ": Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == goal) {
                System.out.println("Congratulations! You guessed it in " + (i + 1) + " attempts.");
                return;
            } else if (guess > goal) {
                System.out.println("Too high!");
            } else {
                System.out.println("Too low!");
            }
        }
        System.out.println("You've run out of attempts. The number was: " + goal);
    }

    private void askToPlayAgain() {
        while (true) {
            System.out.print("Play again? (y/n): ");
            char again = scanner.next().toLowerCase().charAt(0);
            if (again == 'y') {
                start();
                return;
            } else if (again == 'n') {
                System.out.println("Thanks for playing!");
                System.exit(0);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
