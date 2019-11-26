package com.jonas.alpha.web;

import com.jonas.alpha.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

@Autowired
private AlphaService alphaService;

    @GetMapping("/")
//    @NewSpan("alpha-web-span")
    public String index() throws InterruptedException{
        alphaService.so();
        return "service alpha";
    }

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String error()  {

        return "service alpha";
    }

    @GetMapping("/serverError")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String error2()  {

        return "service alpha";
    }
}
