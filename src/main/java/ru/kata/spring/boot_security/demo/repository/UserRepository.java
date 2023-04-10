package ru.kata.spring.boot_security.demo.repository;



import ru.kata.spring.boot_security.demo.models.Users;

import java.util.List;

public interface UserRepository {

    List<Users> getAllUsers();

    void createUser(Users user);

    void updateUser(Users user);

    Users readUser(int id);

    void deleteUser(int id);
}
