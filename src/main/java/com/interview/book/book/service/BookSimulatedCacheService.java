package com.interview.book.book.service;

import com.interview.book.book.repository.dbo.BookDbo;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookSimulatedCacheService {

    private List<BookCache> cachedBooks = new ArrayList<>();

    private long TTL = 1;

    public BookCache getBookFromCache(Integer id) {
        Optional<BookCache> bookCacheOptional = cachedBooks.stream().filter(cb -> cb.getId().equals(id)).findFirst();
        if (bookCacheOptional.isEmpty()) return null;
        if (differenceBetweenTwoLocalDatesInMinutes(bookCacheOptional.get().getInsertionDate(),LocalDateTime.now()) > TTL) {
            cachedBooks.removeIf(cb -> cb.getId().equals(id));
            return null;
        } else {
            System.out.println("Book was found in Cache");
            return bookCacheOptional.get();
        }
    }

    public void addBookToCache(BookCache bookCache) {
        Optional<BookCache> bookCacheOptional = cachedBooks.stream().filter(cb -> cb.getId().equals(bookCache.getId())).findFirst();
        if (bookCacheOptional.isPresent()) {
            cachedBooks.removeIf(cb -> cb.getId().equals(bookCache.getId()));
        }
        bookCache.setInsertionDate(LocalDateTime.now());
        cachedBooks.add(bookCache);
    }

    private long differenceBetweenTwoLocalDatesInMinutes(LocalDateTime fromDate, LocalDateTime toDate) {
        return ChronoUnit.MINUTES.between(fromDate,toDate);
    }

    public BookDbo fromBookCacheToBookDbo(BookCache bookCache) {
        return BookDbo.builder()
                .id(bookCache.getId())
                .name(bookCache.getName())
                .author(bookCache.getAuthor())
                .sn(bookCache.getSn()).build();
    }

    public BookCache fromBookDboToBookCache(BookDbo bookDbo) {
        return BookCache.builder()
                .id(bookDbo.getId())
                .name(bookDbo.getName())
                .author(bookDbo.getAuthor())
                .sn(bookDbo.getSn()).build();
    }
}
