package com.example.springbootkafkastream.controller;

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

    @PostMapping("/send")
    public boolean send(@RequestBody Student student){

        // 通过streamBridge直接对应的topic发送消息
        student.setId(++count);
        streamBridge.send("kafka2-out-0", student);

        return true;
    }

    @PostMapping("/send2")
    public boolean send2(@RequestBody Student student){

        // 通过streamBridge直接对应的topic发送消息
        student.setId(++count);
        streamBridge.send("haha-out-0", student);

        return true;
    }
    
}