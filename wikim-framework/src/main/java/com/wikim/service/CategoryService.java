package com.wikim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.Category;


/**
 * 分类表(WkCategory)表服务接口
 *
 * @author makejava
 * @since 2022-04-27 18:10:08
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

