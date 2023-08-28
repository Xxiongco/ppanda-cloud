package com.gateway.springboot8090gateway.com.panda.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gate-way")
public class TestController {

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }
}
