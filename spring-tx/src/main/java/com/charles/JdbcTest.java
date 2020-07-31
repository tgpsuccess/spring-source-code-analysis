package com.charles;

import com.charles.config.MyConfig;
import com.charles.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chales.tang
 * @title JdbcTest
 * @discription
 * @date 2020/7/31 11:26 上午
 */
public class JdbcTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);

        OrderService orderService = applicationContext.getBean("orderServiceImpl", OrderService.class);

        // 创建JDK动态代理事务拦截
        orderService.addOrder();

        // 打印所有注册的beanNames
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
