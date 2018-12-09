package com.clz.xp;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TestClient {

   /* public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpGet=new HttpGet("http://localhost:9002/collpase");
        HttpResponse response=httpClient.execute(httpGet);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }*/


    public static void main(String[] args) throws  Exception{
        final CloseableHttpClient httpClient= HttpClients.createDefault();
        for (int i = 0; i <100000000 ; i++) {
            //建立线程访问调用接口
            Thread t=new Thread(){
              public void run(){
                  try{
                      String uri="http://localhost:9002/feign/hello";
                      HttpGet get=new HttpGet(uri);
                      HttpResponse response=httpClient.execute(get);
                      System.out.println(EntityUtils.toString(response.getEntity()));
                  }catch (Exception e){
                      e.printStackTrace();
                  }
              }
            };
            t.start();
            Thread.sleep(10);
        }

    }


}