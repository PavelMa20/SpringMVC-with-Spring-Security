package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    List<User> listUsers();

    User getUserById(long id);

    User getUserByLogin(String name);

    void removeUser(long id);
}
