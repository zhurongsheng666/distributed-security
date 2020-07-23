package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/18 14:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class);
    }

}
