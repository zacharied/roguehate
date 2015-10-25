package com.zachdayz.roguehate.log;

import java.io.PrintStream;
import java.util.EnumMap;
import java.util.Map;

public class GameLog {
    private static Map<LogLevel, PrintStream> printers = new EnumMap<>(LogLevel.class);

    public static void initializeForDesktop() {
        printers.put(LogLevel.INFO, System.out);
        printers.put(LogLevel.DEBUG, System.out);
        printers.put(LogLevel.ERROR, System.err);
    }

    public static void log(LogLevel logLevel, String tag, String message) {
        printers.get(logLevel).println(generateMessage(logLevel, tag, message));
    }

    public static void i(String tag, String message) {
        log(LogLevel.INFO, tag, message);
    }

    public static void d(String tag, String message) {
        log(LogLevel.DEBUG, tag, message);
    }

    public static void e(String tag, String message) {
        log(LogLevel.ERROR, tag, message);
    }

    private static String generateMessage(LogLevel logLevel, String tag, String message) {
        return tag + " / " + logLevel.name() + ": " + message;
    }

    private enum LogLevel {
        INFO,
        DEBUG,
        ERROR;
    }
}
