package com.wikim.controller;

import com.wikim.annotation.SystemLog;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.User;
import com.wikim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userInfo")
    @SystemLog(businessName = "获取用户信息")
    public ResponseResult userInfo() {
        return userService.userInfo();
    }

    @PostMapping("/register")
    @SystemLog(businessName = "用户注册")
    public ResponseResult register(@RequestBody User user) {
        return userService.register(user);
    }

    @PutMapping("/userInfo")
    @SystemLog(businessName = "用户更新信息")
    public ResponseResult updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }
}
