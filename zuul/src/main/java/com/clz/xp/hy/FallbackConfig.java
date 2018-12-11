package com.clz.xp.hy;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallbackConfig {

    @Bean
    public ZuulFallbackProvider fallbackProvider(){
        return new MyFallbackProvider();
    }

}
