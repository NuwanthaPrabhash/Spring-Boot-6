package com.nuwantha.springboot.securityConfigurations.controller;

import com.nuwantha.springboot.securityConfigurations.model.Users;
import com.nuwantha.springboot.securityConfigurations.service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(value = "/addUsers")
    public Users addUsers(@RequestBody Users user) {
        return this.usersService.addUsers(user);
    }
}
