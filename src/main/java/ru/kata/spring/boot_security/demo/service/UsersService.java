package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.Users;

import java.util.List;


public interface UsersService {
    Users getUserById(Long id);

    Users getUserByUsername(String username);
    void addUser(Users user);
    List<Users> listUsers();
    //User getUser(long id);

    void deleteUser(long id);

    void editUser(Users updateUser);
}
