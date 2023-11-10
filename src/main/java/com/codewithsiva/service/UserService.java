package com.codewithsiva.service;

import com.codewithsiva.controller.UserController;
import com.codewithsiva.model.User;
import com.codewithsiva.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(User user) {
        return userRepository.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    public User register(User user) {
        userRepository.save(user);
        return user;
    }
}
