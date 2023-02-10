package org.guessNumber;


import org.guessNumber.constants.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.guessNumber.Main.guessNumberGame;
import static org.mockito.Mockito.mock;


class MainTest {

    Scanner scanner = mock(Scanner.class);

    @Test
    public void testCorrectNumberProvided() {
        Mockito.when(scanner.nextInt()).thenReturn(Constants.NUMBER_TO_GUESS);
        guessNumberGame(Constants.NUMBER_TO_GUESS,scanner);

//        Assertions.assertEquals(Level.INFO, handler.checkLevel(), "Log level as expected");
//        Assertions.assertEquals(Constants.CORRECT_ANSWER_MSG,handler.getLastMsg(),"Should guess the number");
    }

    @Test
    public void testLowerNumberProvided() {
        Mockito.when(scanner.nextInt()).thenReturn(Constants.LOWER_NUMBER_THAN_NUMBER_TO_GUESS);
        guessNumberGame(Constants.NUMBER_TO_GUESS, scanner);
    }

    @Test
    public void testGraterNumberProvided() {
        Mockito.when(scanner.nextInt()).thenReturn(Constants.GREATER_NUMBER_THAN_NUMBER_TO_GUESS);
        guessNumberGame(Constants.NUMBER_TO_GUESS, scanner);
    }

}