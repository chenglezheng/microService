package com.clz.xp.controller;

import com.clz.xp.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FirstController {


    @RequestMapping(value="/person/{personId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Long personId, HttpServletRequest request){
        Person person=new Person();
        person.setId(personId);
        person.setAddress("调用了服务1"+request.getRequestURI().toString());
        return person;
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello World";
    }

    @RequestMapping(value="/hello1/{name}",method = RequestMethod.GET)
    public String hello1(@PathVariable("name") String name){
        return "1"+name;
    }

}
