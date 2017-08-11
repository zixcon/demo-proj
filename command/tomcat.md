#### 配置崩溃情况下生成dump文件
1. linux系统：（catalina.sh)
> 增加: JAVA_OPTS="$JAVA_OPTS -server -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/toz/Documents/dev/oom.hprof"
> 不配置HeapDumpPath，默认存放tomcat bin目录下
2. win系统：（catalina.bat)
> 增加: set JAVA_OPTS=%JAVA_OPTS% -server -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\heapdump

#### 配置永久代空间大小PermSize
> 可以理解为类加载空间大小，空间不够时，报错：java.lang.OutOfMemoryError: PermGen space；这块内存主要是被JVM存放Class和Meta信息
> 常见：植入cat监控；在web服务器对JSP进行pre compile的时候；
1. linux系统：（catalina.sh)
> 增加: JAVA_OPTS="$JAVA_OPTS -server -PermSize128m -MaxPermSize1024m"
> 或者 CATALINA_OPTS="$CATALINA_OPTS -server -PermSize128m -MaxPermSize1024m"  后面的省略
2. win系统：（catalina.bat)
> 增加: set JAVA_OPTS=%JAVA_OPTS% -server -PermSize1024m -MaxPermSize1024m

#### 配置堆空间大小
> 运行过程中JVM可以调配使用的内存空间，空间不够时，报错：OutOfMemoryError： Java heap space
1. linux系统：（catalina.sh)
> 增加: JAVA_OPTS="$JAVA_OPTS -server -Xms2048m -Xmx2048m -XX:MaxNewSize=1024m"
2. win系统：（catalina.bat)
> 增加: set JAVA_OPTS=%JAVA_OPTS% -server -Xms2048m -Xmx2048m -XX:MaxNewSize=1024m

注：$JAVA_OPTS是保留先前设置。

#### OutOfMemoryError： unable to create new native thread
> 参照：http://www.cnblogs.com/jinzhenshui/p/3345895.html
