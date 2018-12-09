package com.clz.xp.ribbon;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;

public class MyHttpRequest implements HttpRequest {

    private HttpRequest sourceRequest;

    public MyHttpRequest (HttpRequest sourceRequest){
        this.sourceRequest=sourceRequest;
    }

    public HttpMethod getMethod() {
        return sourceRequest.getMethod();
    }

    public URI getURI() {
        try {
            URI newUri=new URI("http://127.0.0.1:9002/hello");
            return newUri;
        }catch (Exception e){
            e.printStackTrace();
        }
        return sourceRequest.getURI();
    }

    public HttpHeaders getHeaders() {
        return sourceRequest.getHeaders();
    }
}
