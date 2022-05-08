package dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectionToBankDB {
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            FileReader reader = new FileReader("connection.properties");
            Properties dbProperties = new Properties();

            dbProperties.load(reader);
            url = dbProperties.getProperty("url");
            username = dbProperties.getProperty("username");
            password = dbProperties.getProperty("password");
            if (url.isEmpty() || username.isEmpty() || password.isEmpty()) {
                throw new IOException("Connection properties is incorrect");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Please input your connection data to DB in \'connection.properties\' file");
        }
    }

    public Connection getConnection() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConnectionToBankDB.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ConnectionToBankDB.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConnectionToBankDB.password = password;
    }
}
