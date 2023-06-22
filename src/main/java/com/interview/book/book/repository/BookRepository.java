package com.interview.book.book.repository;

import com.interview.book.book.repository.dbo.BookDbo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    List<BookDbo> bookDBOTable = new ArrayList<>();
    int index=1;

    public BookDbo save(BookDbo book){
        book.setId(index++);
        bookDBOTable.add(book);
        return book;
    }

    public Optional<BookDbo> get(Integer id){
        return bookDBOTable.stream().filter(b->b.getId().equals(id)).findFirst();
    }

    public List<BookDbo> getAll(){
        return bookDBOTable;
    }
}
