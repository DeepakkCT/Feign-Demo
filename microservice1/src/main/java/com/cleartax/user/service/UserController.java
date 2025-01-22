package com.cleartax.user.service;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> users = new ArrayList<>();



    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable String id) throws InterruptedException {
         return id;
    }

    @PostMapping("/user/add")
    public void addUser(@RequestBody User user) {
        users.add(user);
    }

}
