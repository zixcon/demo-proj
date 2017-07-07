package com.learning.demo.biz.service.aspect;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;

/**
 * Created by topaz on 2017/7/7.
 */
public class BeanNamedAutoProxyCreator extends AbstractAutoProxyCreator {


    @Override
    protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
        //TODO
        //这里需要对代理类$Proxy91进行名称处理，否则代理类注入会失败
        return super.wrapIfNecessary(bean, beanName, cacheKey);
    }

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> aClass, String s, TargetSource targetSource) throws BeansException {
        return new Object[0];
    }
}
