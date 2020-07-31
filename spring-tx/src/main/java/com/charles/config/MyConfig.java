package com.charles.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author chales.tang
 * @title MyConfig
 * @discription
 * @date 2020/7/31 11:19 上午
 */
@Configuration
@ComponentScan("com.charles")
@EnableTransactionManagement // 开启事务
public class MyConfig {

    // 注入到IOC容器中 beanid = dataSource  class = DataSource类到完整路径地址
    // 配置数据源
    @Bean
    public DataSource dataSource(){

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setDatabaseName("test");
        return dataSource;
    }

    /**
     * @Discription 注入JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager txManager(){
       return new DataSourceTransactionManager(dataSource());
    }
}
