package online_school.util;

public class LogStorage {
    private final String[] logArray = new String[4];

    public void saveLogsArray(Log log) {
        byte i = -1;
        switch (log.getLevel()) {
            case ERROR -> i = 0;
            case WARNING -> i = 1;
            case INFO -> i = 2;
            case DEBUG -> i = 3;
        }
        logArray[i] = logArray[i] == null ? log.toString() : (logArray[i] += log.toString());
    }

    public String[] getLogArray() {
        return logArray;
    }
}
