package com.wikim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-04-27 22:06:33
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

