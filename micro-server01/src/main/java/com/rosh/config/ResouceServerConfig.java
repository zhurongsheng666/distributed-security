package com.rosh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/12 15:08
 */
@Configuration
@EnableResourceServer
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {


    @Autowired
    private TokenStore tokenStore;

    /**
     * 资源ID
     */
    private static final String RESOURCE_ID = "res1";


    /**
     *  资源配置
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                //资源ID
                .resourceId(RESOURCE_ID)
                //验证令牌的服务
                .tokenStore(tokenStore)
                .stateless(true);
    }

    /**
     * 请求配置
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/t1").hasAuthority("t1")
                .antMatchers("/t2").permitAll()
                .antMatchers("/t3").permitAll()
                //验证scope是否是all
                .antMatchers("/**").access("#oauth2.hasScope('ROLE_ADMIN')")
                .and().csrf().disable()
                //不记录session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


}
