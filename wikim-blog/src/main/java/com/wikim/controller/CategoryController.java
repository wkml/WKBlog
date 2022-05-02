package com.wikim.controller;

import com.wikim.annotation.SystemLog;
import com.wikim.domain.ResponseResult;
import com.wikim.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    @SystemLog(businessName = "获取所有分类")
    public ResponseResult getCategoryList() {
        return categoryService.getCategoryList();
    }

}
