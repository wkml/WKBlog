package com.wikim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.Comment;

public interface CommentService extends IService<Comment> {

    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);
}
