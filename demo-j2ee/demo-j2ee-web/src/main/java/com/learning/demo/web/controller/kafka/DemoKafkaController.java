package com.learning.demo.web.controller.kafka;

import com.learning.demo.biz.service.kafka.DemoProducerService;
import com.learning.demo.dal.model.UserInfo;
import com.learning.demo.web.global.entity.BaseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by topaz on 2017/7/5.
 */
@RestController
@RequestMapping("/kafka")
public class DemoKafkaController {

    @Autowired
    private DemoProducerService demoProducerService;

    @ApiOperation(value = "发送请求用例", notes = "发送请求用例")
    @RequestMapping(value = "/sendProducerDemo" ,method = RequestMethod.GET)
    public BaseResult<Object> sendProducerDemo() {
        BaseResult<Object> result = new BaseResult<>();
        demoProducerService.sendProducerDemo();
        return result;
    }
}
