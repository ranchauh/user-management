package org.exmple.service;

import org.exmple.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    User updateUser(String username, User user);

    void deleteUser(String username);

    Optional<User> getUser(String user);

    List<User> getAllUsers();

}
