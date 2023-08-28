package com.panda.springboot9022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Springboot9022Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot9022Application.class, args);
    }

}
