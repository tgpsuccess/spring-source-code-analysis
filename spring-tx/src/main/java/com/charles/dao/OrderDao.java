package com.charles.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author chales.tang
 * @title OrderDao
 * @discription
 * @date 2020/7/31 10:50 上午
 */
@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addOrder(){

        jdbcTemplate.update("insert into order_info values(null,'mayikt','zhangsan')");

    }
}
