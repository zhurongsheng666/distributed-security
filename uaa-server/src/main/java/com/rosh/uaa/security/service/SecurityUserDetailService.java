package com.rosh.uaa.security.service;


import com.rosh.uaa.entity.PermissionEntry;
import com.rosh.uaa.entity.UserEntity;
import com.rosh.uaa.service.PermissionService;
import com.rosh.uaa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/9 23:24
 */
@Service
@Slf4j
public class SecurityUserDetailService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) {

        log.info("username:{}", username);
        UserEntity user = userService.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        //获取权限
        List<PermissionEntry> permissions = permissionService.getPermissionsByUserId(user.getId());
        List<String> codes = permissions.stream().map(PermissionEntry::getCode).collect(Collectors.toList());
        String[] authorities = null;
        if (CollectionUtils.isNotEmpty(codes)) {
            authorities = new String[codes.size()];
            codes.toArray(authorities);
        }
        return User.withUsername(user.getUsername()).password(user.getPassword()).authorities(authorities).build();
    }
}
