package server;

import online_school.log.Log;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class WatcherForBlackIp implements Runnable {
    private final Server server = new Server();

    public void creatWatcher() throws IOException {
        Path path = Paths.get("directory_with_Black_IP");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, ENTRY_MODIFY);
        while (true) {
            WatchKey key;
            try {
                key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == ENTRY_MODIFY) {
                        server.setPresent(true);
                        System.out.println("Were changes in the file!!!");
                    } else {
                        String massage = "Unsupported event kind";
                        System.out.println(massage);
                    }
                }
            } catch (Throwable c) {
                c.printStackTrace();
                return;
            }
            if (!key.reset()) {
                break;
            }
        }
    }

    @Override
    public void run() {
        try {
            creatWatcher();
        } catch (IOException e) {
            Log.error(WatcherForBlackIp.class.getName(), "IO Exception", e.getMessage());
        }
    }

    public Server getServer() {
        return server;
    }
}


