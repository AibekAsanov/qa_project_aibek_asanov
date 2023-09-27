package it.academy.qa_project.service;

import it.academy.qa_project.entity.User;

import java.util.List;

public interface UserService {
    User createUser(String name);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, String newName);

    void deleteUser(Long id);
}
