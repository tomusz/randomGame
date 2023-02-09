package org.guessNumber.helper;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Copied from
 * <p>
 * <a href="https://stackoverflow.com/questions/1827677/how-to-do-a-junit-assert-on-a-message-in-a-logger?page=1&tab=scoredesc#tab-top">...</a>
 */
public class LogHandler extends Handler {
    Level lastLevel = Level.FINEST;
    String lastLog;

    public Level checkLevel() {
        return lastLevel;
    }

    public String getLastMsg() {
        return lastLog;
    }

    public void publish(LogRecord record) {
        lastLevel = record.getLevel();
        lastLog = record.getMessage();
    }

    public void close() {
    }

    public void flush() {
    }
}
