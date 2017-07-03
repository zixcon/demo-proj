
#### apache.common下的属性拷贝，日期为空会抛异常

解决方案： 
>  ConvertUtils.register(new DateConverter(null), java.util.Date.class); 
>  ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class); 
