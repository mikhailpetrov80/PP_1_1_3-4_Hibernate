package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();
    Connection conn = util.getConnect();
    private static final String createUsersTableSql = "CREATE TABLE IF NOT EXISTS USERS (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), lastName VARCHAR(255), age TINYINT)";
    private static final String dropUsersTableSql = "DROP TABLE IF EXISTS USERS";
    private static final String saveUserSql = "INSERT INTO USERS (name, lastname, age) VALUES (?, ?, ?)";
    private static final String removeUserByIdSql = "DELETE FROM USERS WHERE  ? ";
    private static final String getAllUsersSql = "SELECT * FROM USERS";
    private static final String cleanUsersTableSql = "TRUNCATE TABLE USERS";
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createUsersTableSql);
        } catch (SQLException ignored) {
        }
    }

    public void dropUsersTable() {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(dropUsersTableSql);
        } catch (SQLException ignored) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStmt = conn.prepareStatement(saveUserSql)) {
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, lastName);
            preparedStmt.setByte(3, age);
            preparedStmt.executeUpdate();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);
        } catch (SQLException ignored) {
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStmt = conn.prepareStatement(removeUserByIdSql)) {
            preparedStmt.setLong(1, id);
            preparedStmt.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(getAllUsersSql)) {
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setAge(rs.getByte("age"));
                result.add(user);
                System.out.println(user);
            }
        } catch (SQLException ignored) {
        }
        return result;
    }

    public void cleanUsersTable() {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(cleanUsersTableSql);
        } catch (SQLException ignored) {

        }
    }
}
