package com.clz.xp.controller;

import com.clz.xp.entity.Book;
import com.clz.xp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookSaleController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/save/{bookId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBook(@PathVariable Integer bookId){
        Book book=bookService.getBook(bookId);
        System.out.println("获得书名:"+book.getName());
        return "SUCCESS";
    }


}
