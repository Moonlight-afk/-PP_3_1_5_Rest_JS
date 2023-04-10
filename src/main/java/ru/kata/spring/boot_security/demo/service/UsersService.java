package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.models.Users;

import java.util.List;


public interface UsersService {
    List<Users> show();

    void save(Users person);

    Users showid(int id);

    void update(int id, Users userUpdate);

    void delete(int id);

}
