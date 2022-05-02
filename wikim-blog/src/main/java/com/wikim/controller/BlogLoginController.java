package com.wikim.controller;

import com.wikim.annotation.SystemLog;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.User;
import com.wikim.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogLoginController {
    @Autowired
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    @SystemLog(businessName = "登录")
    public ResponseResult login(@RequestBody User user) {
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    @SystemLog(businessName = "登出")
    public ResponseResult logout() {
        return blogLoginService.logout();
    }
}
