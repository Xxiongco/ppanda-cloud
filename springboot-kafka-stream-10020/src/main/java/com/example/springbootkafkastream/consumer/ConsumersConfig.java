package com.example.springbootkafkastream.consumer;

import com.panda.base.domian.Person;
import com.panda.base.domian.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ConsumersConfig {

    @Bean
    public Consumer<String> student() {
        return person -> {
            System.out.println("student 消费: " + person);
        };
    }

    @Bean
    public Consumer<String> student2() {
        return person -> {
            System.out.println("student2 消费: " + person);
        };
    }

    @Bean
    public Consumer<String> student3() {
        return person -> {
            System.out.println("student3 消费: " + person);
        };
    }


    @Bean
    public Consumer<Person> person(){
        return person -> {
            System.out.println("person 消费: " + person);
        };
    }
}