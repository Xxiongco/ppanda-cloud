package com.panda.springboot9022.security;

import com.panda.springboot9022.security.domain.UserDetail;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


// 实现 UserDetailsService （UserDetailsManager） 就相当于 提供了一个根据用户名获取用户的接口
@Component
public class MyUserDetailsService implements UserDetailsManager {


    public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private Map<String, UserDetail> map = new HashMap(){{
//        // 自定义密码加密
//        put("user", new UserDetail("user", "{bcrypt}$2a$10$jVoRsKGmTrWlx3c9H5NEb.olInyaBSXj7mlysnyYrPAjnJq181NJG",
//                Collections.emptyList(), 1L));
//        put("root", new UserDetail("root", "{bcrypt}$2a$10$QoqyU7KXCDqfVl.tS8g9uemh3FzVr6GIkzaeQs2bYTTn2cP/c2OEC",
//                Collections.emptyList(), 2L));

        put("user", new UserDetail("user", "$2a$10$jVoRsKGmTrWlx3c9H5NEb.olInyaBSXj7mlysnyYrPAjnJq181NJG",
                Collections.emptyList(), 1L));
        put("root", new UserDetail("root", "$2a$10$QoqyU7KXCDqfVl.tS8g9uemh3FzVr6GIkzaeQs2bYTTn2cP/c2OEC",
                Collections.emptyList(), 2L));

    }};

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 模拟从数据库获取数据
        return map.get(username);
    }
}
