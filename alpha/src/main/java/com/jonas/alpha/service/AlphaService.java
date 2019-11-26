package com.jonas.alpha.service;

import org.springframework.beans.BeanUtils;
//import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Component;

@Component
public class AlphaService {

//    @NewSpan("alpha-service-span")
    public void so() throws InterruptedException{
//        Thread.sleep(1000L);
        System.out.println("12");
    }
}
