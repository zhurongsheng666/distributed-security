package com.school.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.common.uaa.entity.UserEntity;
import com.common.utils.EncryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/23 00:02
 */
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("json-token");
        if (StringUtils.isNotBlank(token)){
            String json = EncryptUtil.decodeUTF8StringBase64(token);
            JSONObject jsonObject = JSON.parseObject(json);
            //获取用户身份信息、权限信息
            String principal = jsonObject.getString("principal");
            UserEntity user = JSON.parseObject(principal, UserEntity.class);
            JSONArray tempJsonArray = jsonObject.getJSONArray("authorities");
            String[] authorities =  tempJsonArray.toArray(new String[0]);
            //身份信息、权限信息填充到用户身份token对象中
            UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user,null,
                    AuthorityUtils.createAuthorityList(authorities));
            //创建details
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            //将authenticationToken填充到安全上下文
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request,response);
    }
}
