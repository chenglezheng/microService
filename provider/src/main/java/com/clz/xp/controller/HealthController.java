package com.clz.xp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    //标识当前数据库是否可以访问
    static Boolean canVisitDb=true;

    @RequestMapping(value = "/db/{canVisitDb}",method = RequestMethod.GET)
    public String setConnectState(@PathVariable("canVisitDb") Boolean canVisitDb){
        this.canVisitDb=canVisitDb;
        return "当前数据库是否正常："+this.canVisitDb;
    }


}
