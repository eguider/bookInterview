package com.interview.book.book.service;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class BookCache {
    private Integer id;
    private String name;
    private String author;
    private Integer sn;

    private LocalDateTime insertionDate;
}
