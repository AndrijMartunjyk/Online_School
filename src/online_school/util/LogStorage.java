package online_school.util;

public class LogStorage {
    private final String[] logArray = new String[4];

    public void saveLogsArray(Log log) {
        byte i = -1;
        switch (log.getLevel()) {
            case DEBUG -> i = 0;
            case INFO -> i = 1;
            case WARNING -> i = 2;
            case ERROR -> i = 3;
        }
        logArray[i] = logArray[i] == null ? log.toString() : (logArray[i] += log.toString());
    }

    public String[] getLogArray() {
        Log.debug(LogStorage.class.getName(), "method-> \"getLogArray\"");
        return logArray;
    }
}
