package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    public Connection getConnect() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/myDbTest";
        String USERNAME = "root";
        String PASSWORD = "12345";
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
