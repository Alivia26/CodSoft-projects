import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        int range = 100;
        int attempts = 5;
        int score = 0;

        Scanner scanner = new Scanner(System.in);

        // Play multiple rounds
        while (true) {
            System.out.println("Welcome to the number guessing game!");

            // Generate a random number
            int randomNumber = new Random().nextInt(range) + 1;

            // Play one round
            for (int i = 1; i <= attempts; i++) {
                System.out.printf("Attempt %d: Enter your guess between 1 and %d: ", i, range);
                int guess = scanner.nextInt();

                if (guess > randomNumber) {
                    System.out.println("Your guess is too high!");
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low!");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number!");

                    // Increase the score
                    score++;
                    break;
                }
            }

            // Ask the user if they want to play again
            System.out.println("Your score is " + score + " over " + (score > 0 ? score + 1 : 1) + " rounds.");
            System.out.println("Do you want to play again? (yes/no)");

            if (scanner.next().toLowerCase().equals("no")) {
                break;
            }
        }

        System.out.println("Thanks for playing the number guessing game!");

        scanner.close();
    }

}