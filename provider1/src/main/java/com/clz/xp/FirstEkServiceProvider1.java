package com.clz.xp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FirstEkServiceProvider1 {
    public static void main(String[] args){
        new SpringApplicationBuilder(FirstEkServiceProvider1.class).run(args);
    }
}
