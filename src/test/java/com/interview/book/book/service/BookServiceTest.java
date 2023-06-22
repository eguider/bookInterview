package com.interview.book.book.service;

import com.interview.book.book.controller.messaging.BookRequest;
import com.interview.book.book.repository.BookRepository;
import com.interview.book.book.repository.dbo.BookDbo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    BookService bookService = new BookService();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave(){
        BookRequest book = BookRequest.builder().sn(12).name("name").author("auth").build();
        bookService.add(book);

        ArgumentCaptor<BookDbo> bookDboArgumentCaptor = ArgumentCaptor.forClass(BookDbo.class);
        Mockito.verify(bookRepository,Mockito.times(1)).save(bookDboArgumentCaptor.capture());

        BookDbo bookDbo = bookDboArgumentCaptor.getValue();
        assertEquals(12,bookDbo.getSn());
        assertEquals("auth",bookDbo.getAuthor());
        assertEquals("name",bookDbo.getName());
    }
}