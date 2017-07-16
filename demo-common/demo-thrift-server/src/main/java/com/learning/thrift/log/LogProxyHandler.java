package com.learning.thrift.log;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * rpc调用始终在同一个线程中
 * 采用动态代理类, 去拦截rpc的handler接口调用.
 * Created by topaz on 2017/7/16.
 */
public class LogProxyHandler<T> implements InvocationHandler {

    private T instance;

    public LogProxyHandler(T instance) {
        this.instance = instance;
    }

    public Object createProxy() {
        return Proxy.newProxyInstance(instance.getClass().getClassLoader(),
                instance.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        // *) 函数调用前, 拦截处理, 作ThreadLocal的初始化工作
        LoggerTracker.beforeInvoke();    // -----(1)
        Object res;
        try {
            res = method.invoke(instance, args);
            // *) 函数成功返回后, 拦截处理, 进行日志的集中输出
            LoggerTracker.returnInvoke();  // -----(2)
        } catch (Throwable e) {
            // *) 出现异常后, 拦截处理, 进行日志集中输入 // -----(3)
            LoggerTracker.throwableInvode("[result = exception: {%s}]", e.getMessage());
            throw e;
        }
        return res;
    }
}
