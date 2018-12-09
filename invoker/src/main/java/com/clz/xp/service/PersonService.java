package com.clz.xp.service;


import com.clz.xp.feign.PersonClinet;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

    @Autowired
    private PersonClinet personClinet;

    @CacheResult
    @HystrixCommand
    public String hello(){
      /*  String str=null;
        if (str.equals("")){
            System.out.println("NO Hello!");
        }*/
        System.out.println("Hello World!!!!!!!!!!!");
        return   personClinet.hello();
    }

    public String getHello(){
        return  "Hello HystrixCommand";
    }

/*(
            fallbackMethod = "getHello",groupKey = "myGroup",ignoreExceptions = {NullPointerException.class},
            commandKey = "MyCommandKey",threadPoolKey = "MyCommandPool",
            commandProperties = {
              @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "1")
            }
    )*/





}
