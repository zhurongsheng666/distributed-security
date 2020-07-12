package com.rosh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/12 15:04
 */
@RestController
public class TestController {


    /**
     * 拥有R1资源才可以访问
     */
    @GetMapping("/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1() {
        return "访问资源r1";
    }

    @GetMapping("/r2")
    @PreAuthorize("hasAnyAuthority('r2')")
    public String r2() {
        return "访问资源r2";
    }

    @GetMapping("/r3")
    public String r3() {
        return "访问资源r3";
    }

    @GetMapping("/t1")
    public String t1() {
        return "访问资源t1";
    }

    @GetMapping("/t2")
    public String t2() {
        return "访问资源t2";
    }


    @GetMapping("/t3")
    public String t3() {
        return "访问资源t3";
    }
}
