package com.charles.config;

import com.charles.servlet.PayServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author chales.tang
 * @title MyServletContainerInitializer
 * @discription
 * @date 2020/8/4 5:32 下午
 */
@HandlesTypes(MyHandlesType.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * @Discription servlet容器初始化的时候加载一些操作，比如第三方依赖信息，或者手动加载servlet、监听器、过滤器
     * @param set   获取继承MyHandlesType类的所有子类class信息  感兴趣的类
     * @param servletContext
     * @Return void
     */
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

        // 1. 获取感兴趣的类
        for (Class<?> c : set) {
            System.out.println("c:" + c);
        }

        // 2. 手动给容器添加 servlet、监听器、过滤器
        ServletRegistration.Dynamic payServlet = servletContext.addServlet("payServlet", PayServlet.class);
        payServlet.addMapping("/pay");
    }
}
