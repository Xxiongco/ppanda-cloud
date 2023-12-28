package com.panda.springbootkafka.test.resetoffset.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/testResetOffset")
@Slf4j
public class TestResetOffsetController {
    public static String STR_FORMAT = "第%s条消息：%s";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");

    @Value("${topic.test.reset.offset}")
    private String topic;

    @PostMapping("/send/message")
    public void sendMessage(@RequestBody String msg) {
        log.info("send msg : {}", msg);
        String format = SDF.format(new Date());
        int count;
        for (int i = 0; i < 100; i++) {
            count = i + 1;
            String mgsFormat = format + "_" +String.format(STR_FORMAT, count, msg + "_" + count);
            System.out.println(mgsFormat);
            kafkaTemplate.send(topic, mgsFormat);
        }
    }

}
