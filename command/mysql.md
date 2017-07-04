#### 数据库表中只有几条数据，每条数据只有几k大小，但是查询该表占用的实际空间达到了几百兆，是什么原因
1. 问题原因：
> 数据碎片问题
2. 解决办法：
> trancat

#### explain 语法进行sql语句优化
1. type连接类型性能比较
> 依次从好到差：system，const，eq_ref，ref，fulltext，ref_or_null，unique_subquery，index_subquery，range，index_merge，index，ALL。

引用：http://www.cnblogs.com/liujingyuan789/p/6061188.html

