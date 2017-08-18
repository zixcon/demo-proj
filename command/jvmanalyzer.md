#### jvm分析
top ／ ps 等查出 内存／cpu异常的 [pid]

#### 查看gc情况
jstat -gc [pid] 1000
#### JVM堆中对象详细占用情况
jmap -histo [pid]
#### 不终止进程导出内存镜像
jmap -dump:live,format=b,file=heap.dmp [pid]
#### JVM 堆DUMP 文件的工具
1. jhat -J-Xmx1024M [file]
2. eclipse Memory Analyzer
#### JVM 中线程的运行状况，包括锁等待，线程是否在运行
jstack [pid]
#### 其他
