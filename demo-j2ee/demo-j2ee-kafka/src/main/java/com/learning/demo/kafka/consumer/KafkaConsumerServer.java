package com.learning.demo.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * Created by topaz on 2017/7/4.
 */
@Slf4j
public class KafkaConsumerServer implements MessageListener<String,String>{

    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        log.info("=============kafkaConsumer开始消费=============");
        String topic = record.topic();
        String key = record.key();
        String value = record.value();
        long offset = record.offset();
        int partition = record.partition();
        log.info("-------------topic:"+topic);
        log.info("-------------value:"+value);
        log.info("-------------key:"+key);
        log.info("-------------offset:"+offset);
        log.info("-------------partition:"+partition);
        log.info("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
    }
}
