package org.guessNumber;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final int RANDOM_BORDER = 100;
    private static final int MAXIMUM_GUESS_AMOUNT = 5;

    public static void main(String[] args) {
        int numberToGuess = new Random().nextInt(RANDOM_BORDER);
        Scanner scanner = new Scanner(System.in);

        guessNumberGame(numberToGuess, scanner);
    }

    public static void guessNumberGame(int numberToGuess, Scanner scanner) {
        int attemptsCounter = MAXIMUM_GUESS_AMOUNT;

        while (attemptsCounter > 0) {
            logger.log(Level.INFO, "Please provide number in range 0 to 99");
            int numberFromConsole = scanner.nextInt();

            if (numberToGuess == numberFromConsole) {
                logger.log(Level.INFO, "You guessed it!");
                break;
            } else if (numberToGuess > numberFromConsole) {
                logger.log(Level.INFO, "Your number is LOWER than the one you are trying to guess");
            } else {
                logger.log(Level.INFO, "Your number is GREATER than the one you are trying to guess");
            }
            attemptsCounter--;
            if (attemptsCounter != 0) {
                logger.log(Level.INFO, String.format("Please try again %s attempts are left", attemptsCounter));
            } else {
                logger.log(Level.INFO, String.format("Sorry you didn't guess the number, the answer was: %s", numberToGuess));
            }
        }
    }
}