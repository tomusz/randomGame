package org.guessNumber;

import org.guessNumber.constants.Constants;

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
            logger.log(Level.INFO, Constants.PLEASE_PROVIDE_NUMBER_MSG);
            try {
                int numberFromConsole = scanner.nextInt();

                if (numberToGuess == numberFromConsole) {
                    logger.log(Level.INFO, Constants.CORRECT_ANSWER_MSG);
                    break;
                } else if (numberToGuess > numberFromConsole) {
                    logger.log(Level.INFO, Constants.LOWER_ANSWER_MSG);
                } else {
                    logger.log(Level.INFO, Constants.GRATER_ANSWER_MSG);
                }
                attemptsCounter--;
                if (attemptsCounter != 0) {
                    logger.log(Level.INFO, String.format(Constants.PLEASE_TRY_AGAIN_MSG, attemptsCounter));
                } else {
                    logger.log(Level.INFO, String.format(Constants.GAME_LOST_WITH_ANSWER, numberToGuess));
                }
            } catch (RuntimeException ex) {
                logger.log(Level.SEVERE,Constants.PROVIDED_IS_NOT_A_NUMBER_MSG);
                break;
            }

        }
    }
}