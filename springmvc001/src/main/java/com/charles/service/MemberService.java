package com.charles.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author chales.tang
 * @title MemberService
 * @discription
 * @date 2020/8/5 10:11 下午
 */
@Service
public class MemberService {

    @Async
    public String asyncMember(){
        try {
            System.out.println("2. 开始调用会员服务接口...,thread name : " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("3. 结束调用会员服务接口...,thread name : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "member";
    }

    public String callableMember(){
        try {
            System.out.println("2. 开始调用会员服务接口...,thread name : " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("3. 结束调用会员服务接口...,thread name : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "member";
    }


}
