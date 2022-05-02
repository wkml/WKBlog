package com.wikim.controller;

import com.wikim.annotation.SystemLog;
import com.wikim.domain.ResponseResult;
import com.wikim.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/getAllLink")
    @SystemLog(businessName = "获取所有友链")
    public ResponseResult getAllLink() {
        return linkService.getAllLink();
    }
}
