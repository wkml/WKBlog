package com.wikim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
