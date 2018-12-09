package com.clz.xp.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("first-service-provider")
public interface PersonClinet {

    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    String hello();

    @RequestMapping(method = RequestMethod.GET,value = "/hello1/{name}")
    String hello1(@PathVariable("name") String name);

}
