package com.rosh.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/11 20:51
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UaaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaServerApplication.class);
    }
}
