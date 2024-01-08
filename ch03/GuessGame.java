import java.util.Random;
import java.util.Scanner;

/**
 * "Guess My Number" game with added fun features.
 */
public class GuessGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess My Number game!");
        System.out.println("I've picked a number between 1 and 100.");
        System.out.println("Try to guess it!");

        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 15;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Oops! You've reached the maximum number of attempts.");
            System.out.println("The correct number was: " + numberToGuess);
        }

        scanner.close();
    }
}
