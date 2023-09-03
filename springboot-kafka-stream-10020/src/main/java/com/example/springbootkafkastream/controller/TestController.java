package com.example.springbootkafkastream.controller;

import com.panda.base.domian.Person;
import com.panda.base.domian.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream")
public class TestController {

    @Autowired
    private StreamBridge streamBridge;

    private Integer count = 0;

    @PostMapping("/student")
    public boolean student(@RequestBody Student student) throws Exception {

        // 通过streamBridge直接对应的topic发送消息
        for(int i = 0; i < 100; i ++) {
            student.setId(++count);
            System.out.println("student send msg: " + student);
            streamBridge.send("student-out-0", student);
            Thread.sleep(1000);
        }
        return true;
    }

    @PostMapping("/person")
    public boolean person(@RequestBody Person person){

        // 通过streamBridge直接对应的topic发送消息
        person.setId(++count);
        System.out.println("person send msg: " + person);
        return streamBridge.send("person-out-0", person);
    }
    
}