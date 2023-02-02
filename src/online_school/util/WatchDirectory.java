package online_school.util;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchDirectory implements Runnable {
    private final ReadAndWrite readAndWrite = new ReadAndWrite();
    private final Path path;

    public WatchDirectory(Path path) {
        this.path = path;
        Log.debug(WatchDirectory.class.getName(), "method-> \"WatchDirectory\"");
    }

    private void creatWatcher() throws IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, ENTRY_MODIFY);
        while (true) {
            WatchKey key;
            try {
                key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == ENTRY_MODIFY) {
                        readAndWrite.write(Log.getLogArray());
                    } else {
                        String massage = "Unsupported event kind";
                        System.out.println(massage);
                        Log.info(WatchDirectory.class.getName(), massage);
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

    public ReadAndWrite getReadAndWrite() {
        Log.debug(WatchDirectory.class.getName(), "method-> \"getReadAndWrite\"");
        return readAndWrite;

    }

    @Override
    public void run() {
        try {
            creatWatcher();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            Log.error(WatchDirectory.class.getName(), "method->\"getReadAndWrite\"", e.fillInStackTrace().getMessage());
        }
        Log.debug(WatchDirectory.class.getName(), "method-> \"run\"");
    }
}


