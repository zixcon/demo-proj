package com.learning.demo.web.controller.hello;

import com.learning.demo.web.global.entity.BaseResult;
import com.learning.demo.web.vo.HelloValidVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by topaz on 2017/6/23.
 */
@RestController
@RequestMapping("/valid")
public class JSR303ValidController {

    @RequestMapping("/test")
    public BaseResult<HelloValidVO> sayHelloWorld(@Valid HelloValidVO valid) {
        BaseResult<HelloValidVO> result = new BaseResult<>();
        result.setData(valid);
        return result;
    }
}
