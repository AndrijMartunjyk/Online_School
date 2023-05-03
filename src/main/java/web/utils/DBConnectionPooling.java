package web.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionPooling {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(PropertiesLoader.getProperty("db.url"));
        config.setUsername(PropertiesLoader.getProperty("db.username"));
        config.setPassword(PropertiesLoader.getProperty("db.password"));
        config.setDriverClassName(PropertiesLoader.getProperty("db.driver"));

        dataSource = new HikariDataSource(config);
    }

    private DBConnectionPooling() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
