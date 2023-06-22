package com.interview.book.book.repository;

import com.interview.book.book.repository.dbo.BookDbo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    @Test
    public void testSave(){
        BookRepository bookRepository = new BookRepository();
        BookDbo bookDbo = BookDbo.builder().author("auteur").name("nomDuLivre").sn(123).build();
        bookRepository.save(bookDbo);
        List<BookDbo> bookDbos = bookRepository.getAll();
        assertEquals(1,bookDbos.size());
        assertEquals(123,bookDbos.get(0).getSn());
        assertEquals("auteur",bookDbos.get(0).getAuthor());
        assertEquals("nomDuLivre",bookDbos.get(0).getName());
    }

}