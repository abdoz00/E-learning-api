package com.edafa.demo.controller;

import com.edafa.demo.user.ActiveUserStore;
import com.edafa.demo.user.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    ActiveUserStore activeUserStore;

    @GetMapping("/users/active")
    public List getActiveUsers(){
            return activeUserStore.getUsers();
    }
}
