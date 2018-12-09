package com.clz.xp.service;


import com.clz.xp.entity.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("first-service-provider")
public interface BookService {

    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.GET)
    Book getBook(@PathVariable("bookId") Integer bookId);


}
