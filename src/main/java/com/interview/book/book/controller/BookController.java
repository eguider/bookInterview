package com.interview.book.book.controller;

import com.interview.book.book.controller.messaging.BookRequest;
import com.interview.book.book.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);


    @PostMapping("/book")
    public void addBook(@RequestHeader("correlation_id") String correlationId,@RequestBody BookRequest bookRequest){
        logger.info("{} , Add book request has been called {} ", correlationId,bookRequest);
        bookService.add(bookRequest);
        logger.info("{} , Book has been added successfully {} ", correlationId,bookRequest);
    }
    //Make Sure to Comment out the @Cacheable(value = "book",key = "#id") annotation if you want to test the Simulated Cache Service and uncomment to 2 commented functions in BookService
    @Cacheable(value = "book",key = "#id")
    @GetMapping("/book/id/{id}")
    public BookRequest getBook(@RequestHeader("correlation_id") String correlationId,@PathVariable("id") Integer id){
        logger.info("{} , Get book request has been called for id : {} ", correlationId,id);
        BookRequest foundBook = bookService.get(id);
        logger.info("{} , Get book response is : {} ", correlationId,foundBook);
        return foundBook;
    }
}
