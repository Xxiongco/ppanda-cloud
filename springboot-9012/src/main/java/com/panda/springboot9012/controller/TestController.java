package com.panda.springboot9012.controller;

import com.panda.springboot9012.domian.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public List<Student> test() {

        List<Student> list = new ArrayList<>();

        list.add(new Student("你好-9003", "12345", BigDecimal.valueOf(100)));
        list.add(new Student("你好2-9003", "12346", BigDecimal.valueOf(99)));
        list.add(new Student("你好3-9003", "12347", BigDecimal.valueOf(77)));
        list.add(new Student("你好4-9003", "12348", BigDecimal.valueOf(88)));
        list.add(new Student("你好5-9003", "12349", BigDecimal.valueOf(89)));

        return list;
    }
}
