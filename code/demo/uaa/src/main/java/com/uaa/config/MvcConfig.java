package com.uaa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/22 19:51
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /**
     * 视图映射
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }

}
