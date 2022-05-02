package com.wikim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-04-27 22:24:30
 */
public interface UserService extends IService<User> {

    ResponseResult register(User user);

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);
}

