package com.interview.book.book.repository.dbo;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class BookDbo {

    private Integer id;
    private String name;
    private String author;
    private Integer sn;
}
