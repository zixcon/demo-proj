package com.learning.demo.biz.service.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 不建议采用这种方式，会产生的代理无法注入，可能会对事物也有影响（具体未测试）
 * 推荐使用 LogServiceAspect 方式
 * Created by topaz on 2017/7/7.
 */
public class LogServiceInterceptor implements MethodInterceptor{

    /*
    1. 该拦截方式，需要通过spring的xml文件配置这个
    <bean class="org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator">
      		&lt;!&ndash; 拦截器列表 &ndash;&gt;
        	<property name="interceptorNames">
	            <list>
	                <value>serviceLogInterceptor</value>
	            </list>
        	</property>
        	&lt;!&ndash; 指定被代理的Bean名字列表，支持“*”通配符，例如“*DAO”表示所有 id或name以 “DAO”结尾的Bean &ndash;&gt;
	        <property name="beanNames">
	        	<list>
		            <value>*Service</value>
		            <value>*ServiceImpl</value>
		            <value>*Client</value>
		            <value>*ClientImpl</value>
	        	</list>
	        </property>
    	</bean>
    2. 问题说明：
        如果不创建基于接口的Service类，所有的service会生成$Proxy91的代理类，这种方式是无法通过
        @Autowired
        private ***Service ** 注入的。因为类型无法匹配。

        创建基于接口的Service类，则正常。

    3. 解决：
        4.1 自定义实现AbstractAutoProxyCreator类


            通过实现自定义进行还原的方式 参见：BeanNamedAutoProxyCreator
        4.2
        通过Aop注解进行拦截
        <aop:aspectj-autoproxy proxy-target-class=“true"/>

        @Aspect
        @Component
        public class LogAopService {

            @Pointcut("within(@org.springframework.stereotype.Service *)")
            private void serviceAop() {
            }

            @Around("serviceAop()")
            public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

                String name = readAbleString(joinPoint.getSignature().toShortString());
                log.info("aop {} begin to invoke", name);
                Object result = null;
                try {
                    result = joinPoint.proceed();
                } catch (Exception e) {
                    log.error("aop {} args {} has error {}",
                            name, JsonUtil.toJsonString(joinPoint.getArgs()), e.getMessage(), e);
                    throw e;
                    // 这里的异常必须得抛出，否则拦截异常吃掉无法事物无法回滚
                } finally {
                    if (result == null) {
                        log.info("aop {} invoke done, result is null, maybe some error happen");
                    } else {
                        log.info("aop {} invoke done, result is {}", name, JsonUtil.toJsonString(result));
                    }
                }
                return result;
            }
        }
     */




    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String serviceName = invocation.getMethod().getDeclaringClass().getSimpleName();				//获取拦截类的类名
        String methodName = invocation.getMethod().getName();											//获取拦截类的方法名
        Object[] args = invocation.getArguments();														//获取拦截类的参数值
        Object result = null;
        try {
            result = invocation.proceed();
        } catch (Throwable ex) {
            // 记录日志 Log.info();
            throw ex;
        } finally {
            // 记录日志 Log.info();
        }
        return result;
    }
}
