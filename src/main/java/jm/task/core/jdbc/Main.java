package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    User user1 = new User("Женя", "Пупкин", (byte) 35);
    User user2 = new User("Коля", "Батарейкин", (byte) 38);
    User user3 = new User("Петя", "Васечкин", (byte) 32);
    User user4 = new User("Вася", "Петров", (byte) 36);

    String nameTab = "USERS";

    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        //Util util = new Util();
        UserServiceImpl userService = new UserServiceImpl();
        //Connection conn = util.getConnect();
        userService.createUsersTable();
        //userService.dropUsersTable();
    }
}
