package com.panda.springboot9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Springboot9001Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot9001Application.class, args);
    }

}
