package com.charles.service.impl;

import com.charles.dao.OrderDao;
import com.charles.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chales.tang
 * @title OrderServiceImpl
 * @discription
 * @date 2020/7/31 11:14 上午
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    public void addOrder() {
        orderDao.addOrder();
//        int i = 1 / 0;
    }
}
