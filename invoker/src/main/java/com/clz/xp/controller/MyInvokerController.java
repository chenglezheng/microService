package com.clz.xp.controller;


import com.clz.xp.ribbon.MyLoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class MyInvokerController {


    @Bean
    @MyLoadBalanced
    public RestTemplate getMyRestTemplate(){
       return new RestTemplate();
    }

    @RequestMapping(value="/router2",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String findPerson(){
        RestTemplate restTemplate=getMyRestTemplate();
        String json=restTemplate.getForObject("http://first-service-provider/person/1314520",String.class);
        return json;
    }

    @RequestMapping(value="/hello")
    public String hello(){
        return "Hello World!";
    }

}
