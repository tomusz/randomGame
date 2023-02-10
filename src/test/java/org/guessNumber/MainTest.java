package org.guessNumber;


import org.guessNumber.constants.Constants;
import org.guessNumber.helper.LoggerBuilder;
import org.guessNumber.helper.LoggerDirector;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.guessNumber.Main.guessNumberGame;
import static org.mockito.Mockito.mock;


class MainTest {

    Scanner scanner = mock(Scanner.class);
    static LoggerBuilder logBuilder = new LoggerBuilder();
    static LoggerDirector loggerDirector = new LoggerDirector(logBuilder);
    private static Logger logger = loggerDirector.getLogger();
    final Path logDirectoryPath = Path.of("logs\\mainLogs.txt");

    @BeforeEach
    public void setup() {
//        loggerDirector.createFileLoggerAndCommandLogger();
    }

    @Test
    public void testCorrectNumberProvided() throws IOException {
        Path correctLogPath = Path.of("logs\\correctLog.txt");

        Mockito.when(scanner.nextInt()).thenReturn(Constants.NUMBER_TO_GUESS);
        guessNumberGame(Constants.NUMBER_TO_GUESS,scanner);


//        Reader mainLog = new BufferedReader(new FileReader(logDirectoryPath.toFile()));
//        Reader expectedCorrectLog = new BufferedReader(new FileReader(correctLogPath.toFile()));
//        assertTrue(IOUtils.contentEqualsIgnoreEOL(mainLog, expectedCorrectLog));
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