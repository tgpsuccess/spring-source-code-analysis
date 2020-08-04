package com.charles.config;

import com.charles.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author chales.tang
 * @title SpringMvcConfig
 * @discription
 * @date 2020/8/4 8:13 下午
 */
@Configuration
@ComponentScan("com.charles.controller")
@EnableWebMvc // 开启SpringMVC注解方式
public class SpringMvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // 1. 手动注入拦截器到Spring中
    @Bean
    public TokenInterceptor tokenInterceptor(){
        return new TokenInterceptor();
    }

    // 2. 添加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有的请求
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**");
    }
}
