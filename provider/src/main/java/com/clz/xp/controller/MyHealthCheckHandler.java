package com.clz.xp.controller;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    private MyHealthIndicator indicator;

    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus currentStatus) {
        Status status=indicator.health().getStatus();
        if(status.equals(Status.UP)){
            System.out.println("数据库正常连接");
            return InstanceInfo.InstanceStatus.UP;
        }else{
            System.out.println("数据库连接失败");
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
