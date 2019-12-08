package com.credits.demo.controllers;

import com.credits.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping("/block")
    public void blockUser(@RequestBody Long id) {
        userService.blockUser(id);
    }

}
