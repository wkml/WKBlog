package com.wikim.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wikim.constans.SystemConstants;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.VO.CategoryVo;
import com.wikim.domain.entity.Article;
import com.wikim.domain.entity.Category;
import com.wikim.service.ArticleService;
import com.wikim.service.CategoryService;
import com.wikim.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wikim.mapper.CategoryMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(WkCategory)表服务实现类
 *
 * @author makejava
 * @since 2022-04-27 18:10:08
 */
@Service("wkCategoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        //查询文章表， 状态为已发布的文章
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        //获取文章的分类id，并且去重
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleWrapper);
        //查询分类表
        Set<Long> categoryIds = articleList.stream()
                .map(Article::getCategoryId)
                .collect(Collectors.toSet());
        List<Category> categories = listByIds(categoryIds);
        categories = categories.stream().filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());
        //封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }
}

