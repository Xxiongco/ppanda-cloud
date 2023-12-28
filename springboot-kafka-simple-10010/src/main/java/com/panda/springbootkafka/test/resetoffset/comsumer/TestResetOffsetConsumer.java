package com.panda.springbootkafka.test.resetoffset.comsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestResetOffsetConsumer {


    // 消费监听
    @KafkaListener(topics = {"${topic.test.reset.offset}"}, groupId = "topic.test.reset.offset.group")
    public void onMessage(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("TestResetOffsetConsumer group 简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }
}