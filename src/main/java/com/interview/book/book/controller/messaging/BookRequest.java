package com.interview.book.book.controller.messaging;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookRequest {

    private Integer id;
    private String name;
    private String author;
    private Integer sn;
}
