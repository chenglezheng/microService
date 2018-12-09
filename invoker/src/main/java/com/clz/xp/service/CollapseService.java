package com.clz.xp.service;

import com.clz.xp.entity.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Component
public class CollapseService {

    //配置收集1秒内的请求
    @HystrixCollapser(batchMethod = "getPersons",collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds",value = "1")})
    public Future<Person> getSinglePerson(Integer id){
        System.out.println("执行单个的方法");
        return null;
    }

    @HystrixCommand
    public List<Person> getPersons(List<Integer> ids){
        System.out.println("收集请求>>>"+ids.size());
        List<Person> ps=new ArrayList<Person>();
        for (Integer id: ids) {
            Person p= new Person();
            p.setId(Long.parseLong(Integer.toString(id)));
            p.setName("clz");
            ps.add(p);
        }
        return ps;
    }




}
