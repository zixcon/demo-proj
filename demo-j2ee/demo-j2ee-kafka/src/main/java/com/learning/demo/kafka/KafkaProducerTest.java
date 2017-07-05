package com.learning.demo.kafka;

import com.learning.demo.kafka.producer.server.KafkaProducerServer;

import java.util.Map;

/**
 * Created by topaz on 2017/7/4.
 */
public class KafkaProducerTest {

    public static void main(String[] args) {

        KafkaProducerServer kafkaProducer = new KafkaProducerServer();
        String topic = "orderTopic";
        String value = "test";
        String ifPartition = "0";
        Integer partitionNum = 3;
        String role = "test";//用来生成key
        Map<String,Object> res = kafkaProducer.sendMesForTemplate(topic, value, ifPartition, partitionNum, role);

        System.out.println("测试结果如下：===============");
        String message = (String)res.get("message");
        String code = (String)res.get("code");

        System.out.println("code:"+code);
        System.out.println("message:"+message);
    }
}
