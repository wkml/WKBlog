package com.wikim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wikim.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-27 22:24:30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

