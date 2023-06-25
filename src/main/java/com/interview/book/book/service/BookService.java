package com.interview.book.book.service;

import com.interview.book.book.controller.messaging.BookRequest;
import com.interview.book.book.repository.BookRepository;
import com.interview.book.book.repository.dbo.BookDbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookSimulatedCacheService bookSimulatedCacheService;

    /*
    UnComment This function and comment the other if you want to test the simulatedCacheService and make sure to comment the @Cacheable(value = "book",key = "#id") in the BookController
    public void add(BookRequest book){
        BookDbo savedBook = bookRepository.save(buildBookDbo(book));
        bookSimulatedCacheService.addBookToCache(bookSimulatedCacheService.fromBookDboToBookCache(savedBook));
    }*/

    public void add(BookRequest book){
        bookRepository.save(buildBookDbo(book));
    }
    /*
    UnComment This function and comment the other if you want to test the simulatedCacheService  and make sure to comment the @Cacheable(value = "book",key = "#id") in the BookController
    public BookRequest get(Integer id){
        BookCache bookCache = bookSimulatedCacheService.getBookFromCache(id);
        return bookCache == null ? bookRepository.get(id).map(this::buildBookRequest).orElse(null) : buildBookRequest(bookSimulatedCacheService.fromBookCacheToBookDbo(bookCache));
    }*/

    public BookRequest get(Integer id){
        System.out.println("Service is Called which means that the redis cache was not used");
        return bookRepository.get(id).map(this::buildBookRequest).orElse(null);
    }

    private BookDbo buildBookDbo(BookRequest book){
        return BookDbo.builder()
                .sn(book.getSn())
                .name(book.getName())
                .author(book.getAuthor()).build();
    }

    private BookRequest buildBookRequest(BookDbo book){
        return BookRequest.builder()
                .sn(book.getSn())
                .name(book.getName())
                .author(book.getAuthor())
                .id(book.getId()).build();
    }

}
