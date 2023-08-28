package com.panda.springboot9011.controller;

import com.panda.springboot9011.domian.Haha;
import com.panda.springboot9011.domian.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private Haha haha;

    @Value(value = "${nihao.haha.name}")
    private String hello;

    @GetMapping("/hello")
    public List<Student> test() {

//        System.out.println(haha);

        System.out.println(hello);

        List<Student> list = new ArrayList<>();

        list.add(new Student("你好-9002", "12345", BigDecimal.valueOf(100)));
        list.add(new Student("你好2-9002", "12346", BigDecimal.valueOf(99)));
        list.add(new Student("你好3-9002", "12347", BigDecimal.valueOf(77)));
        list.add(new Student("你好4-9002", "12348", BigDecimal.valueOf(88)));
        list.add(new Student("你好5-9003", "12349", BigDecimal.valueOf(89)));

        return list;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
