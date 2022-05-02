package com.wikim.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wkml994
 * 返回给前端登录接口的vo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserLoginVo {
    private String token;
    private UserInfoVo userInfo;
}