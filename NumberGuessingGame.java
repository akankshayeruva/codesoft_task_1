import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        while (playAgain) {
            roundsPlayed++;
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + roundsPlayed);
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts.");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");

                if (scanner.hasNextInt()) {
                    int guess = scanner.nextInt();
                    totalAttempts++;

                    if (guess < minRange || guess > maxRange) {
                        System.out.println("Please enter a number between " + minRange + " and " + maxRange + ".");
                        continue;
                    }

                    if (guess < randomNumber) {
                        System.out.println("Too low!");
                    } else if (guess > randomNumber) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Congratulations! You guessed the correct number!");
                        guessedCorrectly = true;
                    }

                    attemptsLeft--;
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // clear invalid input
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame Over. Rounds played: " + roundsPlayed + ". Total attempts: " + totalAttempts + ".");
        scanner.close();
    }
}