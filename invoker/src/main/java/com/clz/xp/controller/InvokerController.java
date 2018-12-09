package com.clz.xp.controller;

import com.clz.xp.entity.Person;
import com.clz.xp.feign.HelloClinet;
import com.clz.xp.feign.HelloClinetCopy;
import com.clz.xp.feign.PersonClinet;
import com.clz.xp.service.CollapseService;
import com.clz.xp.service.PersonService;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@RestController
@Configuration
public class InvokerController {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value="/router",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String findPerson(){
        RestTemplate restTemplate=getRestTemplate();
        String json=restTemplate.getForObject("http://first-service-provider/person/1314520",String.class);
        return json;
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/router1",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String router(){
       //查找服务列表
        List<ServiceInstance> ins=getServiceInstance();
        //输出服务信息状态
        for (ServiceInstance service : ins){
            EurekaDiscoveryClient.EurekaServiceInstance esi=(EurekaDiscoveryClient.EurekaServiceInstance) service;
            InstanceInfo info=esi.getInstanceInfo();
            System.out.println(info.getAppName()+"======="+info.getInstanceId()+"========"+info.getStatus());
        }
        return "";
    }

    @RequestMapping(value="/router3",method = RequestMethod.GET)
    public String getMetaData(){
        //查找服务列表
        List<ServiceInstance> ins=discoveryClient.getInstances("FIRST-SERVICE-PROVIDER");
        //遍历实例并输出元数据值
        for (ServiceInstance service : ins){
            System.out.println(service.getMetadata().get("company-name"));
        }
        return "";
    }

    /**
     * 查询可用服务
     * @return
     */
    private List<ServiceInstance> getServiceInstance(){
        List<String> ids=discoveryClient.getServices();
        List<ServiceInstance> result=new ArrayList<ServiceInstance>();
        for (String id : ids){
            List<ServiceInstance> ins=discoveryClient.getInstances(id);
            result.addAll(ins);
        }
        return result;
    }



    @Autowired
    private PersonClinet personClinet;

    @RequestMapping(value = "/invokeHello",method = RequestMethod.GET)
    public String invokeHello(){
        return personClinet.hello1("clz");
    }


    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/getHello",method = RequestMethod.GET)
    public String getHello(){

        for (int i = 0; i <5 ; i++) {
            personService.hello();
            System.out.println("控制器可调用服务"+i);
        }
       return personService.hello();
    }

    @Autowired
    private CollapseService collapseService;


    @RequestMapping(value = "/collpase",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String testCollapse () throws Exception{
        Future<Person> f1=collapseService.getSinglePerson(13);
        Future<Person> f2=collapseService.getSinglePerson(14);
        Future<Person> f3=collapseService.getSinglePerson(520);
        Person p1=f1.get();
        Person p2=f2.get();
        Person p3=f3.get();
        System.out.println(p1.getId()+"-----"+p1.getName());
        System.out.println(p2.getId()+"-----"+p2.getName());
        System.out.println(p3.getId()+"-----"+p3.getName());
        return "";
    }

    @Autowired
    private HelloClinet helloClinet;

    @RequestMapping(value = "/feign/hello",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String feignHello(){
       String str= helloClinet.hello();
        /*HystrixCircuitBreaker breaker=HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("HelloClinet#hello()"));
        System.out.println("断路器状态："+breaker.isOpen());*/
        return str;
    }

    @Autowired
    private HelloClinetCopy helloClinetCopy;
    @RequestMapping(value = "/feign/hello/copy",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String feignHelloCopy(){
        String str= helloClinetCopy.hello();
        /*HystrixCircuitBreaker breaker=HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("HelloClinet#hello()"));
        System.out.println("断路器状态："+breaker.isOpen());*/
        return str;
    }

}
