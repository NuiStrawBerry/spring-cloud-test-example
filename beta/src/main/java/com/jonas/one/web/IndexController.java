package com.jonas.one.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index() {
//        String body1 = restTemplate.getForEntity("http://service-alpha", String.class).getBody();
//        String body = restTemplate.getForEntity("http://service-sigma", String.class).getBody();
        String body = restTemplate.getForEntity("http://service-two", String.class).getBody();
        return "service beta";
    }
}
