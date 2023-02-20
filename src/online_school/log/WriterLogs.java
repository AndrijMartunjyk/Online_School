package online_school.log;

import java.io.*;
import java.nio.file.Path;

public class WriterLogs {
    private String pathToFileWithLevels;
    private String pathToFileWithList;

    public void write(String[] logArray) {
        String massage = "method-> \"write\"";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFileWithLevels));
             FileWriter fileWriter = new FileWriter(pathToFileWithList)) {
            String result;
            while ((result = bufferedReader.readLine()) != null) {
                if ((result.contains(Level.DEBUG) || result.contains("debug"))) {
                    for (String s : logArray) {
                        if (s != null) {
                            fileWriter.write(s);
                        }
                    }
                    return;
                }
                if (result.contains(Level.INFO) || result.contains("info")) {
                    for (int i = 1; i < logArray.length; i++) {
                        if (logArray[i] != null) {
                            fileWriter.write(logArray[i]);
                        }
                    }
                    return;
                }
                if (result.contains(Level.WARNING) || result.contains("warning")) {
                    for (int i = 2; i < logArray.length; i++) {
                        if (logArray[i] != null) {
                            fileWriter.write(logArray[i]);
                        }
                    }
                    return;
                }
                if ((result.contains(Level.ERROR) || result.contains("error")) && logArray[3] != null) {
                    fileWriter.write(logArray[3]);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(WriterLogs.class.getName(), massage, e.fillInStackTrace().getMessage());
        }
        Log.debug(WriterLogs.class.getName(), massage);
    }

    public void showLogsOnConsole(Level logName, String[] logArray) {
        switch (logName) {
            case DEBUG -> {
                for (String log : logArray) {
                    if (log != null) {
                        System.out.println(log);
                        Log.info(WriterLogs.class.getName(), log);
                    }
                }
            }
            case INFO -> {
                for (int i = 1; i < logArray.length; i++) {
                    if (logArray[i] != null) {
                        System.out.println(logArray[i]);
                        Log.info(WriterLogs.class.getName(), logArray[i]);
                    }
                }
            }
            case WARNING -> {
                for (int i = 2; i < logArray.length; i++) {
                    if (logArray[i] != null) {
                        System.err.println(logArray[i]);
                        Log.info(WriterLogs.class.getName(), logArray[i]);
                    }
                }
            }
            case ERROR -> {
                if (logArray[3] != null) {
                    System.err.println(logArray[3]);
                    Log.info(WriterLogs.class.getName(), logArray[3]);
                }
            }
        }
        Log.debug(WriterLogs.class.getName(), "method-> \"showLogs\"");
    }

    public void setPathToFileWithLevels(Path pathToFileWithLevels) {
        this.pathToFileWithLevels = String.valueOf(pathToFileWithLevels);
        Log.debug(WriterLogs.class.getName(), "method-> \"setPathToFileWithLevels\"");
    }

    public void setPathToFileWithList(Path pathToFileWithList) {
        this.pathToFileWithList = String.valueOf(pathToFileWithList);
        Log.debug(WriterLogs.class.getName(), "method-> \"setPathToFileWithList\"");
    }
}


