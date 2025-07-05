import java.util.Random; // Import the Random class for generating random numbers
import java.util.Scanner; // Import the Scanner class for user input

/**
 * This class implements a simple "Guess the Number" game.
 * The computer picks a random number, and the user tries to guess it.
 */
public class GuessTheNumber {

    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        // This allows the program to get input from the keyboard.
        Scanner scanner = new Scanner(System.in);

        // Create a Random object to generate random numbers.
        // This will be used to pick the secret number for the game.
        Random random = new Random();

        // Define the range for the random number.
        // The game will pick a number between 1 and 100, inclusive.
        int lowerBound = 1;
        int upperBound = 100;

        // Generate a random number within the specified range.
        // random.nextInt(n) generates a number from 0 to n-1.
        // So, random.nextInt(upperBound - lowerBound + 1) gives a number from 0 to 99.
        // Adding lowerBound (1) shifts it to the range 1 to 100.
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Initialize variables to keep track of the game state.
        int numberOfAttempts = 0; // Counts how many guesses the user has made.
        int userGuess;            // Stores the user's current guess.
        boolean hasGuessedCorrectly = false; // Flag to check if the user has won.

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have picked a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

        // The main game loop. It continues as long as the user hasn't guessed correctly.
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");

            // Check if the next input from the user is an integer.
            // This prevents errors if the user types text instead of a number.
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt(); // Read the integer input from the user.
                numberOfAttempts++;           // Increment the attempt counter.

                // Compare the user's guess with the randomly generated number.
                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    // If the guess is neither too low nor too high, it must be correct.
                    hasGuessedCorrectly = true; // Set the flag to true to exit the loop.
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " in " + numberOfAttempts + " attempts.");
                }
            } else {
                // If the input is not an integer, inform the user and clear the invalid input.
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop.
                                // If we don't do this, hasNextInt() will keep seeing the same invalid input.
            }
        }

        // Close the scanner to release system resources.
        // It's good practice to close resources when you're done with them.
        scanner.close();
        System.out.println("Thanks for playing!");
    }
}