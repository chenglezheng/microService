package com.clz.xp.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "first-service-provider",fallback = HelloClinet.HelloClinetCallback.class)
public interface HelloClinet {


    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String hello();

    @Component
    static class HelloClinetCallback implements HelloClinet{
            public String hello(){
                System.out.println("hello 回退方法");
                return "errror hello";
            }
    }

}
