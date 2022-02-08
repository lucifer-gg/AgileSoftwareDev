package com.example.AgileBackEnd.controller;

import com.example.AgileBackEnd.aop.logAspect.LogAnnotation;
import com.example.AgileBackEnd.entity.params.LoginParam;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    @LogAnnotation("注册")
    public Response register(@RequestBody LoginParam loginParam){
        return userService.register(loginParam);
    }

    @PostMapping("/login")
    @LogAnnotation("登陆")
    public Response login(@RequestBody LoginParam loginParam){
        return userService.login(loginParam);
    }

    @GetMapping("/logout")
    @LogAnnotation("登出")
    public Response logout(@RequestHeader("Authorization") String token){
        return userService.logout(token);
    }

    @GetMapping("/currentUser")
    @LogAnnotation("当前用户")
    public Response currentUser(@RequestHeader("Authorization") String token){
        return userService.findUserByToken(token);
    }




}
