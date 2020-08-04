package com.charles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chales.tang
 * @title IndexController
 * @discription
 * @date 2020/8/4 8:11 下午
 */
//@RestController
@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping("/")
    public String index(){
        return "test mvc";
    }

    @RequestMapping("/pageIndex")
    public String pageIndex(){
        System.out.println(">>>pageIndex<<<");
        return "pageIndex";
    }
}
