package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/myDbTest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public Connection getConnect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ignored) {
        }
        return conn;
    }
}
