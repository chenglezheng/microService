package com.clz.xp.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {


    public Health health(){
        if (HealthController.canVisitDb){
            //成功连接数据库，返回UP
           return new Health.Builder(Status.UP).build();
        }else{
            //成功连接数据库，返回DOWN
            return new Health.Builder(Status.DOWN).build();
        }
    }

}
