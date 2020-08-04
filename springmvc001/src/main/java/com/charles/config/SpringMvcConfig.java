package com.charles.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author chales.tang
 * @title SpringMvcConfig
 * @discription
 * @date 2020/8/4 8:13 下午
 */
@Configuration
@ComponentScan("com.charles.controller")
@EnableWebMvc // 开启SpringMVC注解方式
public class SpringMvcConfig {
}
