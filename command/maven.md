## maven常用命令

#### maven创建项目
##### 创建命令调整为：
> mvn archetype:generate -DgroupId=com.demo -DartifactId=learning-web -Dversion=1.0.0-SNAPSHOT -Dpackage=com.demo -DarchetypeArtifactId=maven-archetype-webapp  -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DarchetypeCatalog=internal

##### 示例(推荐)：
###### 父all： 
`mvn archetype:generate -DgroupId=com.leaning -DartifactId=learning-single-all -Dversion=1.0.0-SNAPSHOT -DarchetypeArtifactId=maven-archetype-site-simple -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DarchetypeCatalog=internal`   
###### 子biz: 
`mvn archetype:generate -DgroupId=com.leaning -DartifactId=learning-single-biz -Dversion=1.0.0-SNAPSHOT -Dpackage=com.learning.biz -DarchetypeArtifactId=maven-archetype-quickstart  -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DarchetypeCatalog=internal`   
###### 子dal: 
`mvn archetype:generate -DgroupId=com.leaning -DartifactId=learning-single-dal -Dversion=1.0.0-SNAPSHOT -Dpackage=com.learning.dal -DarchetypeArtifactId=maven-archetype-quickstart  -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DarchetypeCatalog=internal`   
###### 子web: 
`mvn archetype:generate -DgroupId=com.leaning -DartifactId=learning-single-web -Dversion=1.0.0-SNAPSHOT -Dpackage=com.learning.web -DarchetypeArtifactId=maven-archetype-webapp  -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DarchetypeCatalog=internal`

#### 打包maven项目（跳过test）：
`mvn install -Dmaven.test.skip=true`

#### 已有的Archetypes
| Archetype ID| 说明           |
| ----------- |:--------------:|
| maven-archetype-archetype | 一个样例原型 |
| maven-archetype-j2ee-simple | 简单的J2EE应用程序样例 |
| maven-archetype-mojoMaven | 插件样本的示例 | 
| maven-archetype-pluginMaven | 插件样本 | 
| maven-archetype-plugin-siteMave | 插件网站的样例 | 
| maven-archetype-portletJSR-268 | 门户样例 | 
| maven-archetype-quickstartMaven | 工程样例 | 
| maven-archetype-simple | 一个简单的Maven工程 | 
| maven-archetype-siteMaven | 网站的样例，它演示了对诸如APT、XDoc和FML等文档类型的支持，
并演示了如果把网站国际化（i18n） | 
| maven-archetype-site-simpleMaven | 网站样例 | 
| maven-archetype-webappMaven的Webapp | 工程样例 | 
