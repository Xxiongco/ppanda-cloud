package com.panda.springbootkafka.simple.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer2 {

    // 消费监听
    @KafkaListener(topics = {"${kafka.topic.test}"}, groupId = "kafka.topic.test.group2")
    public void onMessage3(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("onMessage3 group2 简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }
}