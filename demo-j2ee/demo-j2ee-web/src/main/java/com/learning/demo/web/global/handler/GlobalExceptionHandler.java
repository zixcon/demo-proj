package com.learning.demo.web.global.handler;


import com.google.common.base.Strings;
import com.learning.demo.web.global.entity.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        this.handleLog(request,e);
        String errMsg = Strings.isNullOrEmpty(e.getMessage()) ? "请检查参数正确性" : e.getMessage();
        return this.handleBaseResult("-1", errMsg);
    }

    /**
     * JSR303 校验异常提示信息处理
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.OK)
    public BaseResult<?> handleIMethodArgumentNotValidException(HttpServletRequest request, Exception e) {
        this.handleLog(request,e);
        BindingResult bind = null;
        if (e instanceof MethodArgumentNotValidException) {
            bind = ((MethodArgumentNotValidException)e).getBindingResult();
        } else if (e instanceof BindException) {
            bind = ((BindException) e).getBindingResult();
        }
        String err = null;
        if (null != bind && bind.hasErrors()) {
            err = bind.getFieldError().getDefaultMessage();
        }
//        StringBuffer stringBuffer = new StringBuffer();
//        if ( null != bind) {
//            List<ObjectError> errList = bind.getAllErrors();
//            for (ObjectError err: errList) {
//                if (!Strings.isNullOrEmpty(err.getDefaultMessage())) {
//                    stringBuffer.append(err.getDefaultMessage()).append("\n");
//                }
//            }
//        }
//        String errMsg = Strings.isNullOrEmpty(stringBuffer.toString()) ? "请检查参数正确性" : stringBuffer.toString();
        String errMsg = Strings.isNullOrEmpty(err) ? "请检查参数正确性" : err;
        return this.handleBaseResult("-1", errMsg);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleSQLException(HttpServletRequest request, Exception e) {
        this.handleLog(request,e);
        String errMsg = Strings.isNullOrEmpty(e.getMessage()) ? "服务器异常" : e.getMessage();
        return this.handleBaseResult("-1", errMsg);
    }

    private BaseResult<?> handleBaseResult(String errCode, String errMsg) {
        BaseResult<Object> result = new BaseResult<Object>();
        result.setCode(errCode);
        result.setSuccess(false);
        result.setMessage(errMsg);
        return result;
    }

    private void handleLog(HttpServletRequest request, Exception e) {
        log.error("access {} has error {} ", urlPathHelper.getRequestUri(request), e.getMessage(), e);
    }
}
