package com.charles.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author chales.tang
 * @title WebInitializer
 * @discription
 * @date 2020/8/4 8:18 下午
 */
public class WebInitializer implements WebApplicationInitializer {

    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

        // 1. 启动SpringMVC容器 将类注入到Spring中
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

        // 2. 注入SpringMVC配置类
        applicationContext.register(SpringMvcConfig.class);

        // 3. 将DispatcherServlet注入到Servlet容器中
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));

        // 4. 填写url路径映射
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1); // 优先级最高
        dynamic.setAsyncSupported(true); // 开启SpringMVC异步
    }
}
