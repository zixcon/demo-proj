package com.learning.demo.biz.service.kafka;

import com.learning.demo.kafka.producer.server.KafkaProducerServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by topaz on 2017/7/5.
 */
@Service
@Slf4j
public class DemoProducerService {

    @Autowired
    private KafkaProducerServer kafkaProducerServer;

    public void sendProducerDemo() {
        String topic = "orderTopic";
        String value = "test";
        String ifPartition = "0";
        Integer partitionNum = 3;
        String role = "test";//用来生成key
        Map<String,Object> res = kafkaProducerServer.sendMesForTemplate(topic, value, ifPartition, partitionNum, role);

        log.info("测试结果如下：===============");
        String message = (String)res.get("message");
        String code = (String)res.get("code");

        log.info("code:{}",code);
        log.info("message:{}",message);
    }
}
