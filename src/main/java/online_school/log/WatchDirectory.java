package online_school.log;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchDirectory implements Runnable {
    private final WriterLogs writerLogs = new WriterLogs();
    private final Path path;

    public WatchDirectory(Path path) {
        this.path = path;
        Log.debug(WatchDirectory.class.getName(), "method-> \"WatchDirectory\"");
    }

    public void creatWatcher() throws IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, ENTRY_MODIFY);
        while (true) {
            WatchKey key;
            try {
                key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == ENTRY_MODIFY) {
                        writerLogs.write(Log.getLogArray());
                        return;
                    } else {
                        Log.info(WatchDirectory.class.getName(), "Unsupported event kind");
                    }
                }
            } catch (Throwable c) {
                c.printStackTrace();
                Log.error(WatchDirectory.class.getName(), "method->\"creatWatcher\"", c.fillInStackTrace().getMessage());
                return;
            }
            if (!key.reset()) {
                break;
            }
        }
        Log.debug(WatchDirectory.class.getName(), "method-> \"creatWatcher\"");
    }

    public WriterLogs getWriterLogs() {
        Log.debug(WatchDirectory.class.getName(), "method-> \"getReadAndWrite\"");
        return writerLogs;

    }

    @Override
    public void run() {
        try {
            creatWatcher();
        } catch (IOException e) {
            Log.error(WatchDirectory.class.getName(), "method->\"getReadAndWrite\"", e.fillInStackTrace().getMessage());
        }
        Log.debug(WatchDirectory.class.getName(), "method-> \"run\"");
    }
}


