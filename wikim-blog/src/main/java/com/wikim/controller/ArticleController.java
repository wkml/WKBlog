package com.wikim.controller;

import com.wikim.annotation.SystemLog;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.Article;
import com.wikim.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/hotArticleList")
    @SystemLog(businessName = "获取热门文章")
    public ResponseResult hotArticleList() {
        //查询热门文章 封装成ResponseResult
        return articleService.hotArticleList();
    }

    @GetMapping("/articleList")
    @SystemLog(businessName = "获取文章")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        return articleService.articleList(pageNum, pageSize, categoryId);

    }

    @GetMapping("/{id}")
    @SystemLog(businessName = "获取文章详情")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id){
        return articleService.getArticleDetail(id);
    }
}
