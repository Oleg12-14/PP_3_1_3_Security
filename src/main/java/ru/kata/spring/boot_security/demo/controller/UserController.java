package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUserInfo(Principal principal, ModelMap model) {
        User user = userService.loadUserByUsername(principal.getName());
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : user.getAuthorities()) {
            roles.append(authority.getAuthority());
        }
        model.addAttribute("user", user);
        model.addAttribute("roles", roles.toString());
        return "user";
    }


}
