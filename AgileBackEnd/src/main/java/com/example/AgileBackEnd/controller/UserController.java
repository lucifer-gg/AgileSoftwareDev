package com.example.AgileBackEnd.controller;

import com.example.AgileBackEnd.entity.params.LoginParam;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.service.UserService;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Response register(@RequestBody LoginParam loginParam){
        return userService.register(loginParam);
    }
    @PostMapping("/login")
    public Response login(@RequestBody LoginParam loginParam){
        return userService.login(loginParam);
    }

    @GetMapping("/logout")
    public Response logout(@RequestHeader("Authorization") String token){
        return userService.logout(token);
    }

    @GetMapping("/currentUser")
    public Response currentUser(@RequestHeader("Authorization") String token){
        return userService.findUserByToken(token);
    }




}
