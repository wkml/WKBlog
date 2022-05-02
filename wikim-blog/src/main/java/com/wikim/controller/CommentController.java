package com.wikim.controller;

import com.wikim.annotation.SystemLog;
import com.wikim.constans.SystemConstants;
import com.wikim.domain.ResponseResult;
import com.wikim.domain.entity.Comment;
import com.wikim.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList")
    @SystemLog(businessName = "获取所有文章的的评论")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {
        return commentService.commentList(SystemConstants.ARTICLE_COMMENT, articleId, pageNum, pageSize);
    }

    @GetMapping("/linkCommentList")
    @SystemLog(businessName = "获取所有友链的评论")
    public ResponseResult linkCommentList(Integer pageNum, Integer pageSize) {
        return commentService.commentList(SystemConstants.LINK_COMMENT, null, pageNum, pageSize);
    }

    @PostMapping
    @SystemLog(businessName = "添加评论")
    public ResponseResult addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }
}
