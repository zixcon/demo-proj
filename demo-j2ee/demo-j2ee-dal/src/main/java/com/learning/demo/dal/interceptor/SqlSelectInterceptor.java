package com.learning.demo.dal.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * mytatis 拦截Select语句进行空字符串处理，例：
 * select * from tb where column1='' and cloumn2='iterm'
 * =>
 * select * from tb where cloumn2='iterm'
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        )
})
public class SqlSelectInterceptor implements Interceptor {

    private boolean formatEmptyToNull = true;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (formatEmptyToNull) {
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            String commandName = mappedStatement.getSqlCommandType().name();
            if ("SELECT".equalsIgnoreCase(commandName)) {
                Object parameterObject = invocation.getArgs()[1];
                if (null != parameterObject) {
                    reflect(parameterObject);
                }
            }
        }
        return invocation.proceed();
    }

    /**
     * String类型字段值转化： "" -> null
     *
     * @param obj
     * @throws IllegalAccessException
     */
    private void reflect(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        Object value;
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType() == String.class) {
                value = field.get(obj);
                if ("".equals(value)) {
                    field.set(obj, null);
                }
            }
        }

    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
    }

    public void setFormatEmptyToNull(boolean formatEmptyToNull) {
        this.formatEmptyToNull = formatEmptyToNull;
    }
}
