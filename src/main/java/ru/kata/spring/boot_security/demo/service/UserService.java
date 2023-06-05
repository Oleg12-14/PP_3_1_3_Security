package ru.kata.spring.boot_security.demo.service;

import org.springframework.validation.BindingResult;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.List;

public interface UserService {
    User loadUserByUsername(String username);
    User findUserById(Long userId);
    List<User> allUsers();
    boolean saveUser(User user);
    boolean updateUser(User user, BindingResult bindingResult);
    boolean deleteUser(Long userId);
    RoleRepository getRoleRepository();
}
