package com.wikim.service;

import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.User;

public interface BlogLoginService {
    ResponseResult login(User user);
}
