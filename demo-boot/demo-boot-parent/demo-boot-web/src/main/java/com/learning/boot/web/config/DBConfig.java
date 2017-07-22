package com.learning.boot.web.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by topaz on 2017/7/20.
 */
@EnableConfigurationProperties({DBProperties.class})
@MapperScan(value = "com.learning.boot.dal.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
//@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
public class DBConfig {

    @Autowired
    private DBProperties dbProperties;

    @Bean
    @Primary //Spring Boot Jdbc的自动配置过程中，会对于开发者透明地使用dataSource进行一些相关配置，所以当有两个Datasource实现类时，Spring Boot将无法确定使用哪一个。
    public DataSource dataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(dbProperties.getUrl());
//        druidDataSource.setUsername(dbProperties.getUsername());
//        druidDataSource.setPassword(dbProperties.getPassword());
//        return druidDataSource;
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(dbProperties.getUrl());
        dataSourceBuilder.username(dbProperties.getPassword());
        dataSourceBuilder.password(dbProperties.getPassword());
        return dataSourceBuilder.build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] mapperLocations = resolver.getResources("classpath:mapper/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.learning.boot.dal.model");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
