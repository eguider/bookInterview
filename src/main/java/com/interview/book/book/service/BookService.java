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

    public void add(BookRequest book){
        bookRepository.save(buildBookDbo(book));
    }

    public BookRequest get(Integer id){
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
