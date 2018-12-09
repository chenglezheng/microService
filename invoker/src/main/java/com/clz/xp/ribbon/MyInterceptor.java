package com.clz.xp.ribbon;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class MyInterceptor implements ClientHttpRequestInterceptor {
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("================这是自定义拦截器");
        System.out.println("原来的URI======"+httpRequest.getURI());
        //换成新的uri
        MyHttpRequest newRequest=new MyHttpRequest(httpRequest);
        System.out.println("新来的URI======"+newRequest.getURI());
        return clientHttpRequestExecution.execute(newRequest,bytes);
    }
}
