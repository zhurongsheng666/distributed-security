package com.school.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/18 14:40
 */
@RestController
@RequestMapping("/student")
public class StudentController {


    /**
     * 老师权限或学生权限
     */
    @GetMapping("/grade")
    @PreAuthorize("hasAnyAuthority('teacher','student')")
    public Object rs(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        map.put("张三",100);
        return map;
    }


}
