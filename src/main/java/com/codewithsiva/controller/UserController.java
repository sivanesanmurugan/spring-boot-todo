package com.codewithsiva.controller;

import com.codewithsiva.model.User;
import com.codewithsiva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @PutMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

}
