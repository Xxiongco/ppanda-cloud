package com.panda.springbootkafka.simple.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public static String STR_FORMAT = "第%s条消息：%s";

    @Value("${kafka.topic.test}")
    private String topic;

    // 发送消息
    @PostMapping("/send/message")
    public void sendMessage1(@RequestBody String msg) throws Exception {
        for (int i = 0; i < 100; i++) {
            String format = String.format(STR_FORMAT, i, msg + i);
            log.info("send msg : {}", format);
            kafkaTemplate.send(topic, format);
            Thread.sleep(1000);
        }
    }


    @PostMapping("/send/message2")
    public void sendMessage2(@RequestBody String msg) {
        log.info("send msg : {}", msg);
        kafkaTemplate.send(topic, msg);
    }
}