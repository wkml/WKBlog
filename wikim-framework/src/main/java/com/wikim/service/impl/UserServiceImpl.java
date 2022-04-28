package com.wikim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wikim.domain.entity.User;
import com.wikim.mapper.UserMapper;
import com.wikim.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-04-27 22:24:30
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

