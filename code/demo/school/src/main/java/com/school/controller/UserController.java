package com.school.controller;

import com.common.uaa.entity.UserEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/23 00:50
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户信息
     */
    @GetMapping("/user")
    public UserEntity user() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


    /**
     * 获取用户信息，p1权限测试
     */
    @GetMapping("/p1")
    @PreAuthorize("hasAuthority('p1')")
    public String p1() {
        return "p1权限测试";
    }

    /**
     * 获取用户信息，p1权限测试
     */
    @GetMapping("/p3")
    @PreAuthorize("hasAuthority('p3')")
    public String p3() {
        return "p3权限测试";
    }

}
