package com.learning.demo.web.controller.hello;

import com.google.common.base.Preconditions;
import com.learning.demo.web.vo.HelloWorldVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by topaz on 2017/6/22.
 */
@RestController("/hello")
public class HelloController {

    @RequestMapping("/say")
    public HelloWorldVO sayHelloWorld(HelloWorldVO say) {
        return say;
    }

    @RequestMapping("/err")
    public HelloWorldVO errTest(HelloWorldVO say) {
        Preconditions.checkArgument(false,"这里是异常提示信息");
        return say;
    }
}
