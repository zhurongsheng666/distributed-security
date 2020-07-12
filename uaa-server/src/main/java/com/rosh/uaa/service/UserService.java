package com.rosh.uaa.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rosh.uaa.entity.UserEntity;
import com.rosh.uaa.mapper.UserMapper;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/10 01:19
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

    public UserEntity getUserByUsername(String username) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return baseMapper.selectOne(wrapper);
    }



}
