package com.example.test.controller;

import com.example.test.bean.User;
import com.example.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{UserID}")
    public User getUserById(@PathVariable("UserID") Integer UserID){
        return userMapper.getUserById(UserID);
    }

    @GetMapping("/user")
    public User insertUser(User user){
        userMapper.insertUser(user);
        return user;
    }

}
