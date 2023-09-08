package com.panda.springbootkafka.simple.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/single")
@Slf4j
public class SingleKafkaProducer {

    public static String STR_FORMAT = "第%s条消息：%s";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.single}")
    private String topic;

    private int count = 1;

    @PostMapping("/send/message")
    public void sendMessage2(@RequestBody String msg) {
        log.info("send msg : {}", msg);
        count++;
        String mgsFormat = String.format(STR_FORMAT, count, msg + "-" + count);

        kafkaTemplate.send(topic, mgsFormat);
    }
}