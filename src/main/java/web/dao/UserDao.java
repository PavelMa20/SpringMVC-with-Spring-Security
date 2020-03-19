package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    List<User> listUsers();

    User getUserById(long id);
    User getUserbyLogin(String name);

    void removeUser(long id);
}
