package com.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: admin
 * @Date: 0000/9/09 18:44
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.minIdle:10}")
    private int minIdle;
    @Value("${spring.datasource.maxActive:50}")
    private int maxActive;
    @Value("${spring.datasource.maxLifetime}")
    private int maxLifetime;
    @Value("${spring.datasource.idleTimeout}")
    private int idleTimeout;

    @Value("${spring.datasource0.url}")
    private String url0;
    @Value("${spring.datasource0.username}")
    private String username0;
    @Value("${spring.datasource0.password}")
    private String password0;
    @Value("${spring.datasource0.driverClassName}")
    private String driverClassName0;

    @Value("${spring.datasource1.url}")
    private String url1;
    @Value("${spring.datasource1.username}")
    private String username1;
    @Value("${spring.datasource1.password}")
    private String password1;
    @Value("${spring.datasource1.driverClassName}")
    private String driverClassName1;

    @Autowired
    private CustomerDataSourceFactory customerDataSourceFactory;

    @Bean("dataSource0")
    public DataSource dataSource0() {
        return initDataSource(url0,username0,password0,driverClassName0);
    }

    @Bean("dataSource1")
    public DataSource dataSource1() {
        return initDataSource(url1,username1,password1,driverClassName1);
    }

    @Bean(name = "shardingDataSource")
    public DataSource shardingDataSource(@Qualifier("dataSource0") DataSource dataSource0,
                                         @Qualifier("dataSource1") DataSource dataSource1) throws SQLException {
        Map<String,DataSource> map= new HashMap<>();
        map.put("ds_master",dataSource0);
        map.put("ds_slave",dataSource1);
        return customerDataSourceFactory.createDataSource(map);
    }


    private DataSource initDataSource(String url,String username,String password, String driverClassName) {
        HikariDataSource datasource = new HikariDataSource();
        datasource.setJdbcUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setMaximumPoolSize(maxActive);
        datasource.setMinimumIdle(minIdle);
        datasource.setMaxLifetime(maxLifetime);
        datasource.setIdleTimeout(idleTimeout);
        datasource.setConnectionTestQuery("select 1");
        return datasource;
    }
}
