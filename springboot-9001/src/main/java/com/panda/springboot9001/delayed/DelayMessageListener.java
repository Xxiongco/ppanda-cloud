package com.panda.springboot9001.delayed;

public interface DelayMessageListener<E extends DelayMessage> {
    // 返回消息
    void onMessage(E e);

    // 主题
    String topic();
}
