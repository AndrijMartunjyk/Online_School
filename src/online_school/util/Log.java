package online_school.util;

import java.time.LocalDateTime;

public class Log {
    private static final LogStorage LOG_STORAGE = new LogStorage();
    private final LocalDateTime date = LocalDateTime.now();
    private Level level;
    private String name;
    private String message;
    private String stacktrace;

    public Log() {
    }

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
        LOG_STORAGE.saveLogsArray(new Log(Level.ERROR, className, message, stacktrace));
    }

    public static void warning(String className, String message, String stacktrace) {
        LOG_STORAGE.saveLogsArray(new Log(Level.WARNING, className, message, stacktrace));
    }

    public static void info(String className, String message) {
        LOG_STORAGE.saveLogsArray(new Log(Level.INFO, className, message));
    }

    public static void debug(String className, String message) {
        LOG_STORAGE.saveLogsArray(new Log(Level.DEBUG, className, message));
    }

    @Override
    public String toString() {
        return "Log {" +
                "date=" + date +
                ", level=" + level +
                ", class name='" + name + '\'' +
                ", message='" + message + '\'' +
                toString2() +
                "}\n";
    }


    public String toString2() {
        String result = "";
        if (level.equals(Level.ERROR) || level.equals(Level.WARNING)) {
            result = ", stacktrace='" + stacktrace;
        }
        return result;
    }


    public Level getLevel() {
        return level;
    }

    public String[] getLogArray() {
        return LOG_STORAGE.getLogArray();
    }
}
