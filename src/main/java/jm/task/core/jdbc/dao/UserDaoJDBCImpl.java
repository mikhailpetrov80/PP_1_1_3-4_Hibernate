package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection conn = util.getConnect(); Statement stmt = conn.createStatement()) {
            String createUsersTableSql = "CREATE TABLE IF NOT EXISTS USERS (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), lastName VARCHAR(255), age TINYINT)";
            stmt.executeUpdate(createUsersTableSql);
        } catch (SQLException ignored) {
        }
    }

    public void dropUsersTable() {
        try (Connection conn = util.getConnect(); Statement stmt = conn.createStatement()) {
            String dropUsersTableSql = "DROP TABLE IF EXISTS USERS";
            stmt.executeUpdate(dropUsersTableSql);
        } catch (SQLException ignored) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUserSql = "INSERT INTO USERS (name, lastname, age) VALUES (?, ?, ?)";
        try (Connection conn = util.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(saveUserSql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setByte(3, age);
            pstmt.executeUpdate();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);
        } catch (SQLException ignored) {
        }
    }

    public void removeUserById(long id) {
        String removeUserByIdSql = "DELETE FROM USERS WHERE  ? ";
        try (Connection conn = util.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(removeUserByIdSql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        String getAllUsersSql = "SELECT * FROM USERS";
        try (Connection conn = util.getConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(getAllUsersSql)) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                byte age = rs.getByte("age");
                User user = new User();
                user.setName(name);
                user.setLastName(lastName);
                user.setAge(age);
                result.add(user);
                System.out.println(user);
            }
            conn.commit();
        } catch (SQLException ignored) {
        }
        return result;
    }

    public void cleanUsersTable() {
        try (Connection conn = util.getConnect(); Statement stmt = conn.createStatement()) {
            String sql = "TRUNCATE TABLE USERS";
            stmt.executeUpdate(sql);
        } catch (SQLException ignored) {

        }
    }
}
