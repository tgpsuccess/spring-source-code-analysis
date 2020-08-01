package com.charles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author chales.tang
 * @title AService
 * @discription
 * @date 2020/8/1 11:58 上午
 */
@Service
@Scope("prototype")
public class AService {

//    @Autowired
    private BService bService;

    public void setbService(BService bService){
        this.bService = bService;
    }
}
