package com.charles.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chales.tang
 * @title IndexController
 * @discription
 * @date 2020/8/4 8:11 下午
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "test mvc";
    }
}
