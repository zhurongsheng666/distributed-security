package com.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/18 14:43
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class);
    }
}
