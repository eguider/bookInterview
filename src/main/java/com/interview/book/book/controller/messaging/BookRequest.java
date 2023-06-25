package com.interview.book.book.controller.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest implements Serializable {

    private Integer id;
    private String name;
    private String author;
    private Integer sn;
}
