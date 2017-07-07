package com.learning.demo.biz.service.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by topaz on 2017/7/7.
 */
@Aspect
@Component
public class LogServiceAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogServiceAspect.class);

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    private void serviceAop() {
    }

    @Around("serviceAop()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        String name = joinPoint.getSignature().toShortString();
        logger.info("aop {} begin to invoke", name);
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            logger.error("aop {} args {} has error {}", name, JSON.toJSON(joinPoint.getArgs()), e.getMessage(), e);
            throw e;
            // 这里的异常必须得抛出，否则拦截异常吃掉无法事物无法回滚
        } finally {
            if (result == null) {
                logger.info("aop {} invoke done, result is null, maybe some error happen");
            } else {
                logger.info("aop {} invoke done, result is {}", name, JSON.toJSON(result));
            }
        }
        return result;
    }
}
