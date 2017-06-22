package com.learning.demo.global;


import com.google.common.base.Strings;
import com.learning.demo.global.entity.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by topaz on 2017/6/21.
 */
@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalExceptionHandler {

    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResult<?> handleIlleagalArgumentException(HttpServletRequest request, Exception e) {
        BaseResult<Object> result = new BaseResult<Object>();
        result.setCode("-1");
        result.setSuccess(false);
        if (!Strings.isNullOrEmpty(e.getMessage())) {
            result.setMessage(e.getMessage());
        } else {
            result.setMessage("参数异常");
        }
        log.error("access {} has error {} ", urlPathHelper.getRequestUri(request), e.getMessage(), e);
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleSQLException(HttpServletRequest request, Exception ex) {
        BaseResult<Object> result = new BaseResult<Object>();
        result.setCode("-1");
        result.setSuccess(false);
        result.setMessage("服务器异常");
        log.error("access {} has error {} ", urlPathHelper.getRequestUri(request), ex.getMessage(), ex);
        return result;
    }
}
