package com.al.saas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.config
 * @ClassName:WebSecurityConfig
 * @Description
 * @date2021/9/6 17:37
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //解决layui嵌套页面不生效-防止iframe
        http.headers().frameOptions().sameOrigin();
    }
}
