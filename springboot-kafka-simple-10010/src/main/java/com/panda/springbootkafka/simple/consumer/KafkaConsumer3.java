package com.panda.springbootkafka.simple.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer3 {

    // 消费监听
    @KafkaListener(topics = {"${kafka.topic.test}"})
    public void onMessage4(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("onMessage4 group default 简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }
}