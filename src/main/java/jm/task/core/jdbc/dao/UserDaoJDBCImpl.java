package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();
    Connection conn = util.getConnect();
    Statement stmt = conn.createStatement();
    public UserDaoJDBCImpl() throws SQLException {

    }

    public void createUsersTable() throws SQLException {

        String sql = "CREATE TABLE USERS " +
                "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                " name VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age TINYINT)";

        stmt.executeUpdate(sql);
    }

    public void dropUsersTable() throws SQLException {
        String sql = "DROP TABLE USERS";
        stmt.executeUpdate(sql);
    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
