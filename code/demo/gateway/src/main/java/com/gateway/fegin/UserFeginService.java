package com.gateway.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/21 00:24
 */
@FeignClient("uaa-server")
public interface UserFeginService {


    @GetMapping("/user/authentication")
    String getAuthentication();

}
