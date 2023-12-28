package com.panda.springbootkafka.simple.domain;


import lombok.Data;

@Data
public class KafkaMsg {

    private String topic;

    private Object content;
}
