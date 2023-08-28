package com.panda.springboot9022.controller;

import com.alibaba.fastjson.JSONObject;
import com.panda.springboot9022.config.ConfigBeanValue;
import com.panda.springboot9022.config.MyProperty;
import com.panda.springboot9022.domain.Person;
import com.panda.springboot9022.feign.Panda9002Server;
import com.panda.springboot9022.security.domain.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Value("${panda.name}")
    private String name;

    @Autowired
    private ConfigBeanValue configBeanValue;

    @Autowired
    private MyProperty myProperty;

    @Autowired
    private Validator validator;

    @Autowired
    private Panda9002Server panda9002Server;

    @PostMapping("/hello")
    public String test(@RequestBody Person person) {


        Set<ConstraintViolation<Person>> resultSet = validator.validate(person);

        for (ConstraintViolation<Person> personConstraintViolation : resultSet) {
            log.error("{} : {}", personConstraintViolation.getPropertyPath(),
                    personConstraintViolation.getMessage());
        }

        if (!CollectionUtils.isEmpty(resultSet)) {
            String s = (resultSet.stream().map((item) ->
                 item.getPropertyPath().toString() + " " + item.getMessage() + "; "
            ).collect(Collectors.toList())).toString();

            System.out.println(s);
        }

        System.out.println(configBeanValue.getName());

        System.out.println(myProperty.getName());

        System.out.println(name);

        return name;
    }

    @GetMapping("/hello2")
    public String test2() {
        List<Person> test = panda9002Server.test();

        for (Person person : test) {
            System.out.println(person);
        }

        return JSONObject.toJSONString(test);
    }

    @GetMapping("/hello3")
    public String test3() {

        return "hello3-public";
    }

    @GetMapping("/hello4")
    public String test4() {

        SecurityContext context = SecurityContextHolder.getContext();

        Object details = context.getAuthentication().getDetails();
        UserDetail principal = (UserDetail)context.getAuthentication().getPrincipal();
        System.out.println("parent: " + principal.getUsername());
        new Thread(() -> {
            // 默认是线程级别的（MODE_THREADLOCAL）子线程无法使用
            // 需要配置 -Dspring.security.strategy=MODE_INHERITABLETHREADLOCAL 启动参数
            SecurityContext childSecurityContext = SecurityContextHolder.getContext();
            Object childDetails = childSecurityContext.getAuthentication().getDetails();
            UserDetail childPrincipal = (UserDetail)childSecurityContext.getAuthentication().getPrincipal();
            System.out.println("child: " + childPrincipal.getUsername());
        }).start();



        return "hello4-limit";
    }

}
