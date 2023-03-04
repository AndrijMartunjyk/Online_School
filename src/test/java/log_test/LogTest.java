package log_test;

import online_school.log.Level;
import online_school.log.WatchDirectory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

class LogTest {
    WatchDirectory watchDirectory;
    String[] arrayTest;

    @BeforeEach
    void greatTestObject() {
        watchDirectory = new WatchDirectory(Path.of("directory_with_log_levels"));
        arrayTest = new String[]{"one ", "two ", "three ", "four "};

        watchDirectory.getWriterLogs().setPathToFileWithLevels(Path.of("directory_with_log_levels/Level of logs.txt"));
        watchDirectory.getWriterLogs().setPathToFileWithList(Path.of("directory_with_log_levels/list_of_logs.txt"));
    }

    //run the test and write anything in the file (directory_with_log_levels/Level of logs.txt)
    @Test
    void setCreatWatcher() {
        try {
            watchDirectory.creatWatcher();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     first write :info, debug, error, warning or anything in the file (directory_with_log_levels/Level of logs.txt),
     than run the test and look in the file (directory_with_log_levels/list_of_logs.txt)
    */
    @Test
    void setWriterLogsWrite() {
        watchDirectory.getWriterLogs().write(arrayTest);
    }

    //write in the method parameter: Level.DEBUG, Level.ERROR, Level.INFO or Level.WARNING
    @Test
    void setShowLogsOnConsole() {
        watchDirectory.getWriterLogs().showLogsOnConsole(Level.DEBUG, arrayTest);
    }
}
