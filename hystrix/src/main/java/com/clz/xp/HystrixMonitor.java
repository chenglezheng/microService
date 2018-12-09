package com.clz.xp;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixMonitor {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixMonitor.class).properties("server.port=9003").run(args);
    }
}
