package org.guessNumber.helper;

import java.util.logging.Logger;

public class LoggerDirector {

    private LoggerBuilder loggerBuilder;

    public LoggerDirector(LoggerBuilder loggerBuilder) {
        this.loggerBuilder = loggerBuilder;
    }

    public Logger getLogger() {
        return this.loggerBuilder.getLogger();
    }

    public void createFileLoggerAndCommandLogger() {
        this.loggerBuilder.addConsoleHandler()
                .addFileHandler().build();
    }
}