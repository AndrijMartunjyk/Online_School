package online_school.util;

import java.io.*;
import java.util.Arrays;

public class ReadAndWrite {

    private final String file = "Loggers.txt";

    public void info(Level logName, String[] getLogArray) {
        writeIt(getLogArray);
        int result;
        StringBuilder s = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            while ((result = fileReader.read()) != -1) {
                s.append((char) result);
            }
            String[] logs = s.toString().split("\n");
            for (String log : logs) {
                switch (logName) {
                    case DEBUG -> stringLog(log);
                    case INFO -> {
                        if (!log.contains("DEBUG")) {
                            stringLog(log);
                        }
                    }
                    case WARNING -> {
                        if (log.contains("ERROR") || log.contains("WARNING")) {
                            System.err.println(log);
                        }
                    }
                    case ERROR -> {
                        if (log.contains("ERROR")) {
                            System.err.println(log);
                        }
                    }
                }
            }
        } catch (IOException n) {
            System.out.println(n.getMessage());
            Log.error(ReadAndWrite.class.getName(), "method->\"info\"", Arrays.toString(n.getStackTrace()));
        }
    }

    private void writeIt(String[] getLogArray) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String log : getLogArray) {
                if (log != null) {
                    fileWriter.write(log);
                }
            }
        } catch (IOException n) {
            System.out.println(n.getMessage());
            Log.error(ReadAndWrite.class.getName(), "method->\" writeIt\"", Arrays.toString(n.getStackTrace()));
        }
    }

    private void stringLog(String log) {
        if (log.contains("ERROR") || log.contains("WARNING")) {
            System.err.println(log);
        } else System.out.println(log);
    }

    public void deleteLogFile() {
        File file1 = new File(file);
        System.out.println(file1.delete() ? "Файл з логами видалено!!!" : "Файл з логами не видалено!!!");
    }
}


