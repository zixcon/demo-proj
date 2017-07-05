package com.learning.demo.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

/**
 * Created by topaz on 2017/7/4.
 */
@Slf4j
public class kafkaProducerListener implements ProducerListener<String, String> {

    @Override
    public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
        log.info("==========kafka发送数据成功（日志开始）==========");
        log.info("----------topic:" + topic);
        log.info("----------partition:" + partition);
        log.info("----------key:" + key);
        log.info("----------value:" + value);
        log.info("----------RecordMetadata:" + recordMetadata);
        log.info("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");
    }

    @Override
    public void onError(String topic, Integer partition, String key, String value, Exception exception) {
        log.info("==========kafka发送数据错误（日志开始）==========");
        log.info("----------topic:" + topic);
        log.info("----------partition:" + partition);
        log.info("----------key:" + key);
        log.info("----------value:" + value);
        log.info("----------Exception:" + exception);
        log.info("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
        exception.printStackTrace();
    }

    /**
     * 方法返回值代表是否启动kafkaProducer监听器
     */
    @Override
    public boolean isInterestedInSuccess() {
        log.info("///kafkaProducer监听器启动///");
        return true;
    }
}
