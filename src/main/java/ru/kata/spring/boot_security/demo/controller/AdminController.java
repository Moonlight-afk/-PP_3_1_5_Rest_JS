package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Users;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UsersServiceImpl;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UsersServiceImpl userService;
    private final RoleServiceImpl roleService;

    public AdminController(UsersServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String listUsers(ModelMap model, Principal principal) {
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("admin" , userService.getUserByUsername(principal.getName()));
        model.addAttribute("newUser" ,new Users());
        model.addAttribute("roles" , roleService.getAllRoles());
        return "admin";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") Users user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") Users user) {
        userService.editUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
