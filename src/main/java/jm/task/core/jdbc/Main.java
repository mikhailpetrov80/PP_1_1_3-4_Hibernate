package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Женя", "Пупкин", (byte) 35);
        userService.saveUser("Коля", "Батарейкин", (byte) 38);
        userService.saveUser("Петя", "Васечкин", (byte) 32);
        userService.saveUser("Вася", "Петров", (byte) 36);
        //userService.getAllUsers();
        //userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
