package org.guessNumber.helper;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerBuilder {



    private ConsoleHandler consoleHandler;
    private FileHandler fileHandler;

    private Logger logger;

    public Logger getLogger() {
        return logger;
    }

    public LoggerBuilder () {
        LogManager.getLogManager().reset();
        logger = LogManager.getLogManager().getLogger("");
    }

    public Logger build() {
        return logger;
    }

    public LoggerBuilder addConsoleHandler() {
        consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new CustomFormatter());
        logger.addHandler(consoleHandler);
        return this;
    }

    public LoggerBuilder addFileHandler() {
        try {
            File logFile = new File("logs\\mainLogs.txt");
            fileHandler = new FileHandler(logFile.getPath());
            fileHandler.setFormatter(new CustomFormatter());
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            logger.addHandler(fileHandler);
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
        return this;
    }
}