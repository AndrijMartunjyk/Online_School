package online_school.util;

import java.io.*;
import java.nio.file.Path;

public class ReadAndWrite {
    private String pathToFileWithLevels;
    private String pathToFileWithList;
    private String result;

    public void write(String[] logArray) {
        String massage = "method-> \"write\"";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFileWithLevels));
             FileWriter fileWriter = new FileWriter(pathToFileWithList)) {
            String result;
            while ((result = bufferedReader.readLine()) != null) {
                this.result = result;
            }
            if (this.result.contains(Level.DEBUG)) {
                for (String s : logArray) {
                    if (s != null) {
                        fileWriter.write(s);
                    }
                }
            }
            if (this.result.contains(Level.INFO)) {
                for (int i = 1; i < logArray.length; i++) {
                    if (logArray[i] != null) {
                        fileWriter.write(logArray[i]);
                    }
                }
            }
            if (this.result.contains(Level.WARNING)) {
                for (int i = 2; i < logArray.length; i++) {
                    if (logArray[i] != null) {
                        fileWriter.write(logArray[i]);
                    }
                }
            }
            if (this.result.contains(Level.ERROR)) {
                if (logArray[3] != null) {
                    fileWriter.write(logArray[3]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(ReadAndWrite.class.getName(), massage, e.fillInStackTrace().getMessage());
        }
        Log.debug(ReadAndWrite.class.getName(), massage);
    }

    public void showLogsOnConsole(Level logName, String[] logArray) {
        switch (logName) {
            case DEBUG -> {
                for (String log : logArray) {
                    if (log != null) {
                        System.out.println(log);
                        Log.info(ReadAndWrite.class.getName(), log);
                    }
                }
            }
            case INFO -> {
                for (int i = 1; i < logArray.length; i++) {
                    if (logArray[i] != null) {
                        System.out.println(logArray[i]);
                        Log.info(ReadAndWrite.class.getName(), logArray[i]);
                    }
                }
            }
            case WARNING -> {
                for (int i = 2; i < logArray.length; i++) {
                    if (logArray[i] != null) {
                        System.err.println(logArray[i]);
                        Log.info(ReadAndWrite.class.getName(), logArray[i]);
                    }
                }
            }
            case ERROR -> {
                if (logArray[3] != null) {
                    System.err.println(logArray[3]);
                    Log.info(ReadAndWrite.class.getName(), logArray[3]);
                }
            }
        }
        Log.debug(ReadAndWrite.class.getName(), "method-> \"showLogs\"");
    }

    public void setPathToFileWithLevels(Path pathToFileWithLevels) {
        this.pathToFileWithLevels = String.valueOf(pathToFileWithLevels);
        Log.debug(ReadAndWrite.class.getName(), "method-> \"setPathToFileWithLevels\"");
    }

    public void setPathToFileWithList(Path pathToFileWithList) {
        this.pathToFileWithList = String.valueOf(pathToFileWithList);
        Log.debug(ReadAndWrite.class.getName(), "method-> \"setPathToFileWithList\"");
    }
}


