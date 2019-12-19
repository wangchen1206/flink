package com.flink.flinksource;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: cc
 * @Date: 2019/11/1 15:26
 */
@Component
public class KafkaReceiver {

    @KafkaListener(groupId = "mygroup",topics = "my-topic")
    public void receive1(Foo msg) {
        System.out.println("receive msg is :" + msg);
    }
}
