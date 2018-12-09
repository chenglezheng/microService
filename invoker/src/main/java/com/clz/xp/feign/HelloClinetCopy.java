package com.clz.xp.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "first-service-provider",fallback = HelloClinetCopy.HelloClinetCallback.class)
public interface HelloClinetCopy {


    @RequestMapping(method = RequestMethod.GET,value = "/hello/copy")
    public String hello();

    @Component
    static class HelloClinetCallback implements HelloClinetCopy {
            public String hello(){
                System.out.println("hello 回退方法");
                return "errror hello";
            }
    }

}
