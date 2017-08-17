## maven常用命令

#### maven创建项目
##### 创建命令调整为：
> mvn archetype:generate 
> -DgroupId=com.demo -DartifactId=learning-web -Dpackage=com.demo -Dversion=1.0.0-SNAPSHOT
> -DarchetypeArtifactId=maven-archetype-webapp  
> -DarchetypeGroupId=org.apache.maven.archetypes 
> -DinteractiveMode=false 
> -DarchetypeCatalog=internal

##### 示例(推荐)：
###### 父all： 
`mvn archetype:generate -DgroupId=com.leaning.demo -DartifactId=learning-demo-all -Dversion=1.0.0-SNAPSHOT -DarchetypeArtifactId=maven-archetype-site-simple -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DarchetypeCatalog=internal`
###### 子biz: 
`mvn archetype:generate -DgroupId=com.leaning -DartifactId=learning-single-biz -Dversion=1.0.0-SNAPSHOT -Dpackage=com.learning.biz -DarchetypeArtifactId=maven-archetype-quickstart  -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DarchetypeCatalog=internal`   
###### 子dal: 
`mvn archetype:generate -DgroupId=com.leaning -DartifactId=learning-single-dal -Dversion=1.0.0-SNAPSHOT -Dpackage=com.learning.dal -DarchetypeArtifactId=maven-archetype-quickstart  -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DarchetypeCatalog=internal`   
###### 子web: 
`mvn archetype:generate -DgroupId=com.leaning -DartifactId=learning-single-web -Dversion=1.0.0-SNAPSHOT -Dpackage=com.learning.web -DarchetypeArtifactId=maven-archetype-webapp  -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DarchetypeCatalog=internal`

#### 打包maven项目（跳过test）：
`mvn install -Dmaven.test.skip=true`

#### 使用本地Arche文件，避免从官网下载很慢
`mvn archetype:generate -DarchetypeCatalog=local`

#### maven排除jar包依赖冲突
> mvn dependency:tree -Dverbose

#### 已有的Archetypes
| Archetype ID| 说明           |
| -------------- |:--------------:|
| maven-archetype-archetype | 一个样例原型 |
| maven-archetype-j2ee-simple | 简单的J2EE应用程序样例 |
| maven-archetype-mojo | Maven插件样本的示例 | 
| maven-archetype-plugin | Maven插件样本 | 
| maven-archetype-plugin-site | Maven插件网站的样例 | 
| maven-archetype-portlet | JSR-268门户样例 | 
| * maven-archetype-quickstart | Maven工程样例 | 
| maven-archetype-site | Maven网站的样例，它演示了对诸如APT、XDoc和FML等文档类型的支持，并演示了如果把网站国际化（i18n） | 
| * maven-archetype-site-simple | Maven网站样例 | 
| * maven-archetype-webapp | Maven的Webapp工程样例 | 
