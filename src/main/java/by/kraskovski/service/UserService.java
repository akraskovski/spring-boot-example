package by.kraskovski.service;

import by.kraskovski.model.User;

import java.util.List;

public interface UserService {
    User find(String id);

    User findByUsername(String username);

    List<User> findAll();

    User create(User object);

    User update(String id, User object);

    boolean delete(String id);

    boolean deleteAll();
}
