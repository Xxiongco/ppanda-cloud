package com.panda.springboot9022.security.config;

import com.panda.springboot9022.security.handler.MyAuthenticationFailureHandler;
import com.panda.springboot9022.security.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http    // 开启权限管理
                .authorizeRequests()
                // 放行的资源放在之前
                .mvcMatchers("/test/hello3").permitAll()
                // 登录页面是需要放行的资源
                .mvcMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.successHandler(new MyAuthenticationSuccessHandler())
                .failureHandler(new MyAuthenticationFailureHandler())
                .and()
                .httpBasic()
        ;

        // 设置自定义登录页面，一定得 设置 用来处理登录的url
//        http.formLogin().loginPage("login.html").
//                // 用来处理登录的url
//                loginProcessingUrl("/doLogin").
//                usernameParameter("user").
//                passwordParameter("password").
//                successForwardUrl("/index") // 认证成功 跳转路劲
//                .defaultSuccessUrl("/hello") // 重定向跳转
//                .successHandler() // 登录成功处理
//                .failureHandler() // 登录失败处理
//                .failureUrl()
//                .failureForwardUrl()
//        ;

        // 禁止 csrf 跨站请求
        //http.csrf().disable();
    }
}
