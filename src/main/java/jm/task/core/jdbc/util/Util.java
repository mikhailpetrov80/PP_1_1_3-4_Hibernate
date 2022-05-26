package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    final String URL = "jdbc:mysql://localhost:3306/myDbTest";
    final String USERNAME = "root";
    final String PASSWORD = "12345";

    public Connection getConnect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ignored) {
        }
        return conn;
    }
}
