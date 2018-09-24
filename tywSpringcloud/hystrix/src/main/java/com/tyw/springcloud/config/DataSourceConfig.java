package com.tyw.springcloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


public class DataSourceConfig {

    @Bean(name = "mysqlDB")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mysqlDataSource(){
        return DataSourceBuilder.create().build();
    }

}