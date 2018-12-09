package com.clz.xp.ribbon;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class MyAutoConfiguration {

    @Autowired(required = false)
    @MyLoadBalanced
    private List<RestTemplate> myTempates= Collections.emptyList();

    @Bean
    public SmartInitializingSingleton myLoadBalanceRestTemplateInitializer(){
        System.out.println("================ 这个Bean将在容器初始化时创建==============");
        return  new SmartInitializingSingleton() {
            public void afterSingletonsInstantiated() {
                for (RestTemplate template :myTempates){
                    MyInterceptor mi=new MyInterceptor();
                    //获取RestTemplate原来的拦截器
                    List list =new ArrayList(template.getInterceptors());
                    //添加拦截器到结合
                    list.add(mi);
                    //将新的拦截器结合设置到RestTemplate中去
                    template.setInterceptors(list);
                }
            }
        };
    }

}


