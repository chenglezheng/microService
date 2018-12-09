package com.clz.xp.controller;


import com.clz.xp.entity.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookSerachController {


    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable Integer bookId){
        Book book=new Book();
        book.setId(bookId);
        book.setName("clz");
        book.setAuthor("程乐政");
        return book;
    }

}
