package com.charles;

import com.charles.config.MyConfig;
import com.charles.service.AService;
import com.charles.service.BService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;

/**
 * @author chales.tang
 * @title CircularTest
 * @discription
 * @date 2020/8/1 11:55 上午
 */
public class CircularTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);

        AService aService = applicationContext.getBean("AService", AService.class);
        BService bService = applicationContext.getBean("BService", BService.class);

        // Error creating bean with name 'AService': Requested bean is currently in creation: Is there an unresolvable circular reference?
        aService.setbService(bService);
        bService.setaService(aService);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName :beanDefinitionNames){
            System.out.println(beanDefinitionName);
        }

        // Spring 通过三级缓存机制，解决了单例循环依赖的问题


        // 缓存婴儿对象
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        stringObjectHashMap.put("aService1",new AService());
        stringObjectHashMap.put("bService1",new BService());

        // 从三级缓存中查询赋值
        AService aService1 = (AService) stringObjectHashMap.get("aService1");
        BService bService1 = (BService) stringObjectHashMap.get("bService1");
        // set方式注入对象 实现相互依赖
        aService1.setbService(bService1);
        bService1.setaService(aService1);

    }
}
