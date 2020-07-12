package com.rosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/11 21:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Server01Application {

    public static void main(String[] args) {

        SpringApplication.run(Server01Application.class);

    }
}
