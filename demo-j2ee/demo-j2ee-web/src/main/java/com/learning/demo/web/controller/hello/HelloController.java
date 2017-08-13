package com.learning.demo.web.controller.hello;

import com.codahale.metrics.Meter;
import com.google.common.base.Preconditions;
import com.learning.demo.web.global.entity.BaseResult;
import com.learning.demo.web.vo.HelloWorldVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by topaz on 2017/6/22.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Meter requestMeter;

    @RequestMapping("/say")
    public BaseResult<HelloWorldVO> sayHelloWorld(HelloWorldVO say) {
        requestMeter.mark();
        BaseResult<HelloWorldVO> result = new BaseResult<>();
        result.setData(say);
        return result;
    }

    @RequestMapping("/err")
    public BaseResult<HelloWorldVO> errTest(HelloWorldVO say) {
        BaseResult<HelloWorldVO> result = new BaseResult<>();
        Preconditions.checkArgument(false, "这里是异常提示信息");
        result.setData(say);
        return result;
    }

    @RequestMapping("date")
    public Date getDate() {
        return new Date();
    }
}
