package com.interview.book.book.controller;

import com.interview.book.book.controller.messaging.BookRequest;
import com.interview.book.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public void addBook(BookRequest bookRequest){
        bookService.add(bookRequest);
    }

    @GetMapping("/book")
    public BookRequest getBook(Integer id){
        return bookService.get(id);
    }
}
