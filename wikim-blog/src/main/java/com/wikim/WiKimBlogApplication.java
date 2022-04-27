package com.wikim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wkml994
 */
@SpringBootApplication
@MapperScan("com.wikim.mapper")
public class WiKimBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(WiKimBlogApplication.class, args);
    }
}
