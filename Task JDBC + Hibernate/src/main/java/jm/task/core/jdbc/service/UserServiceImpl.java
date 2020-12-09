package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoHibernateImpl userDHI = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDHI.createUsersTable();
    }

    public void dropUsersTable() {
        userDHI.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDHI.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDHI.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDHI.getAllUsers();
    }

    public void cleanUsersTable() {
        userDHI.cleanUsersTable();
    }
}
