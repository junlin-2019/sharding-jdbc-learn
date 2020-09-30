package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/29 18:40
 */
@Configuration
@MapperScan(basePackages = "com.example.dao" ,sqlSessionFactoryRef="shardingSqlSessionFactory" )
public class ShardingMyBatisConfig {


    @Autowired
    @Qualifier("shardingDataSource")
    private DataSource dataSource;

    @Bean("shardingSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.example.entity");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }


}
