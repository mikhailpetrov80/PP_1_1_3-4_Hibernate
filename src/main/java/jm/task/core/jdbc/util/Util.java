package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    String URL = "jdbc:mysql://localhost:3306/myDbTest";
    String USERNAME = "root";
    String PASSWORD = "12345";

    public Connection getConnect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ignored) {
        }
        return conn;
    }
}
