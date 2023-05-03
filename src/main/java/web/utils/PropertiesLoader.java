package web.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesLoader {
    private static final Properties properties;

    static {
        properties = new Properties();

        Path path = Paths.get("C:\\main-project\\Online_School\\web-api\\src\\main\\webapp\\application.properties");

        try (InputStream input = Files.newInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load application.properties file.");
        }
    }

    private PropertiesLoader() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
