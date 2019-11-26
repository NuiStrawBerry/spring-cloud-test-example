package com.jonas.one.web;

import brave.Span;
import brave.Tracer;
import com.jonas.one.service.DeltaService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {

    @Autowired
    private DeltaService deltaService;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Tracer tracer;

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String index() {
        String serviceName = deltaService.getHealth();
        System.out.println(serviceName);

        return "service delta";
    }

    @GetMapping("/rtService")
    public String rtService() {
        String body = restTemplate.getForEntity("http://service-alpha", String.class).getBody();
        String body1 = restTemplate.getForEntity("http://service-beta", String.class).getBody();
        System.out.println(body);
        return StringUtils.isNotBlank(body) ? body : "service delta";

    }

    @GetMapping("/error3")
    public String error() {
        //        String body = restTemplate.getForEntity("http://service-alpha/error1", String.class).getBody();
        try{
            ResponseEntity<String> r = restTemplate.getForEntity("http://service-alpha/error", String.class);
            if(r.getStatusCodeValue()== HttpStatus.OK.value()){
                System.out.println(r.getBody());
            }else {
                System.out.println("=============");
                System.out.println(r.getStatusCode());
                System.out.println(r.getBody());
            }
            return "hello";
        }catch (RestClientException rs){
            ((HttpClientErrorException.BadRequest) rs).getRawStatusCode();
            ((HttpClientErrorException.BadRequest) rs).getResponseBodyAsString();
            System.out.println(((HttpClientErrorException.BadRequest) rs).getRawStatusCode());
            System.out.println(((HttpClientErrorException.BadRequest) rs).getResponseBodyAsString());
            rs.printStackTrace();
        }

        return "error";
    }

    @GetMapping("/error1")
    public String error1() {
//        String body = restTemplate.getForEntity("http://service-alpha/error1", String.class).getBody();
        try{
            ResponseEntity<String> r = restTemplate.getForEntity("http://service-alpha/serverError", String.class);
            if(r.getStatusCodeValue()== HttpStatus.OK.value()){
                System.out.println(r.getBody());
            }else {
                System.out.println("=============");
                System.out.println(r.getStatusCode());
                System.out.println(r.getBody());
            }
        }catch (HttpServerErrorException rs){
            System.out.println(rs.getRawStatusCode());
            System.out.println(rs.getResponseBodyAsString());
//            rs.printStackTrace();
        }catch (HttpClientErrorException.BadRequest rs){
            System.out.println(rs.getRawStatusCode());
            System.out.println(rs.getStatusCode());
            System.out.println(rs.getResponseBodyAsString());
//            rs.printStackTrace();
        }


        return  "service delta";

    }
}
