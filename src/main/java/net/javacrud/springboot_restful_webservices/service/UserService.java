package net.javacrud.springboot_restful_webservices.service;

import net.javacrud.springboot_restful_webservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
