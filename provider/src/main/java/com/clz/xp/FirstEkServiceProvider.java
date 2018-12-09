package com.clz.xp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class FirstEkServiceProvider {

    public static void main(String[] args){
        new SpringApplicationBuilder(FirstEkServiceProvider.class).run(args);
    }

}
