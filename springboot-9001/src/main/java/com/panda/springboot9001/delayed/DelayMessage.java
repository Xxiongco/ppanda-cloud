package com.panda.springboot9001.delayed;

import lombok.Data;

@Data
public class DelayMessage {
    // 主键
    private String id;
    // 应该运行的时间 当前时间 + 延迟时间
    private long shouldRunTime;
    // 延迟的时间
    private long delayTimeMillis;
    // 放置时间 当前时间
    private long putTime;
    // 消息体 id所对应的实体
    private String message;
}