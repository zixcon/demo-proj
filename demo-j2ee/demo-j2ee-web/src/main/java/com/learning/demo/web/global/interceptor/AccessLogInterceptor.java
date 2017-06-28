package com.learning.demo.web.global.interceptor;

import com.google.common.base.Stopwatch;
import com.learning.demo.biz.service.async.OpLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by topaz on 2017/6/23.
 */
@Slf4j
public class AccessLogInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    private OpLogService opLogService;

    private ThreadLocal<Stopwatch> watcher = new NamedThreadLocal<>("watch-time");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        watcher.set(Stopwatch.createStarted());
        opLogService.asyncSaveOpLog();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Stopwatch watch = watcher.get();
        watch.stop();
        log.info("request uri = {} , params = {}, costs time {}",request.getRequestURI(), request.getParameterMap().toString(),watch.toString());
    }
}
