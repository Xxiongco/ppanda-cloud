package com.example.springbootkafkastream.consumer;

import com.panda.base.domian.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

// @Configuration
@Slf4j
public class HahaConsumersConfig {

    @Bean
    public Consumer<Student> haha() {
        return str -> {
            // 收到消息在这里做一些处理
            System.out.println("haha message: " +  str);
        };
    }

}