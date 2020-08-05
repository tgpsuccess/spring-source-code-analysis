package com.charles.controller;

import com.charles.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

/**
 * @author chales.tang
 * @title IndexController
 * @discription
 * @date 2020/8/4 8:11 下午
 */
//@RestController
@Controller
public class IndexController {

    @Autowired
    private MemberService memberService;

    @ResponseBody
    @RequestMapping(value = "/",produces = "text/html;charset=UTF-8")
    public String index(){
        return "test mvc";
    }

    @RequestMapping("/pageIndex")
    public String pageIndex(){
        System.out.println(">>>pageIndex<<<");
        return "pageIndex";
    }

    /**
     * @Discription 异步，无返回结果
     */
    @ResponseBody
    @RequestMapping("/asyncMember")
    public String asyncMember(){

        System.out.println("1. 开始执行getMember>>>,thread name : " + Thread.currentThread().getName());
        String member = memberService.asyncMember();
        System.out.println("4. 结束执行getMember>>>,thread name : " + Thread.currentThread().getName());
        return member;
    }

    /**
     * @Discription 异步，有返回结果，使用Callable
     */
    @ResponseBody
    @RequestMapping("/callableMember")
    public Callable<String> callableMember(){

        System.out.println("1. 开始执行getMember>>>,thread name : " + Thread.currentThread().getName());
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                return memberService.callableMember();
            }
        };
        System.out.println("4. 结束执行getMember>>>,thread name : " + Thread.currentThread().getName());
        return callable;
    }
}
