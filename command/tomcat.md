#### 配置崩溃情况下生成dump文件
1. 打开/tomcat_home/bin/catalina文件
2. 加上：set JAVA_OPTS=%JAVA_OPTS% -server -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\heapdump
