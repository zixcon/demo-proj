####注意事项

1. 自定义mybatis注解／插件后，逆向工程命令建议如下使用：
> mvn mybatis-generator:generate -Dmybatis.generator.overwrite=true -e

其中（-e）表示有异常会打印到控制台，方便查找问题原因
