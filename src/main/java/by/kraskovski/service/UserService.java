package by.kraskovski.service;

import by.kraskovski.model.User;

import java.util.List;

public interface UserService {
    User find(String id);

    List<User> findAll();

    User create(User object);

    User update(User object);

    void delete(String id);
}
