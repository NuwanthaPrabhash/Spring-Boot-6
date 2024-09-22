package com.nuwantha.springboot.securityConfigurations.controller;

import com.nuwantha.springboot.securityConfigurations.model.Users;
import com.nuwantha.springboot.securityConfigurations.service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class AuthenticationController {

    private final UsersService usersService;

    public AuthenticationController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(value = "login")
    public String login(@RequestBody Users user) {
        return usersService.verifyUser(user
        );
    }
}
