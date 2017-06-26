####mybatis-generate
mybatis-generate插件自动生成mapper接口／entity／mapper文件

####问题说明
1. mybatis-generator:generate命令
> 通过该命令生成文件后，在你执行该命令，启动容易出现各种奇奇怪怪的问题，服务就是起不来
> 解决办法：
>   删除该命令生成的所有文件，mvn clean后，重新生成，就正常了。
    
2.mybatis-config.xml文件
<property name="configLocation" value="classpath:mybatis/mybatis-config.xml"/>
>文件内容无所谓，但文件必须得有，这是SqlSessionFactoryBean校验的
