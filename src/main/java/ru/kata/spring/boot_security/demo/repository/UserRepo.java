package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    @Query("select u from Users u left join fetch u.roles where u.username=:username")
    Users findByUsername(String username);
}
