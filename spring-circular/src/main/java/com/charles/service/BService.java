package com.charles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author chales.tang
 * @title BService
 * @discription
 * @date 2020/8/1 11:58 上午
 */
@Service
@Scope("prototype")
public class BService {

//    @Autowired
    private AService aService;

    public void setaService(AService aService){
        this.aService = aService;
    }

    
}
