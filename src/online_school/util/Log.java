package online_school.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final LogStorage logStorage = new LogStorage();
    private final String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss:ms"));
    private final Level level;
    private final String name;
    private final String message;
    private String stacktrace;

    private Log(Level level, String name, String message) {
        this.level = level;
        this.name = name;
        this.message = message;
    }

    private Log(Level level, String name, String message, String stacktrace) {
        this(level, name, message);
        this.stacktrace = stacktrace;

    }

    public static void error(String className, String message, String stacktrace) {
        logStorage.saveLogsArray(new Log(Level.ERROR, className, message, stacktrace));
    }

    public static void warning(String className, String message, String stacktrace) {
        logStorage.saveLogsArray(new Log(Level.WARNING, className, message, stacktrace));
    }

    public static void info(String className, String message) {
        logStorage.saveLogsArray(new Log(Level.INFO, className, message));
    }

    public static void debug(String className, String message) {
        logStorage.saveLogsArray(new Log(Level.DEBUG, className, message));
    }

    @Override
    public String toString() {
        return "Log {" +
                "date=" + date +
                ", level=" + level +
                ", class name='" + name + '\'' +
                ", message='" + message + '\'' +
                creatStacktrace() +
                "}\n";
    }


    public String creatStacktrace() {
        String result = "";
        if (level.equals(Level.ERROR) || level.equals(Level.WARNING)) {
            result = ", stacktrace='" + stacktrace;
        }
        return result;
    }


    public Level getLevel() {
        return level;
    }

    public static String[] getLogArray() {
        return logStorage.getLogArray();
    }
}
