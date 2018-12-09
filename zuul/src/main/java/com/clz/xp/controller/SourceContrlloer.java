package com.clz.xp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourceContrlloer {

    @RequestMapping(value = "/source/hello/{name}",method = RequestMethod.GET)
    public  String hello(@PathVariable("name") String name){
        return  name;
    }

}
