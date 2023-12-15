package com.example.librarybookingsystem.serviceimpls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.librarybookingsystem.entities.Book;
import com.example.librarybookingsystem.exceptions.BookNotFoundException;
import com.example.librarybookingsystem.repositories.BookRepository;

@SpringBootTest
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl bookService;

    @Test
    public void createBookTest() {

        // 1. SETUP
        // Create a new Book
        
        Book book = Book.builder().title("Learn Java in One Day").author("Jamie Chan").genre("Programming").quantity(5).availability(true).build();

        // mock the save method of the Book repository
        when((bookRepository.save(book))).thenReturn(book);

        // 2. EXECUTE
        Book savedBook = bookService.createBook(book);

        // 3. ASSERT
        assertEquals(book, savedBook, "The saved Book should be the same as the new Book.");

        // also verify that the save method of book repository is called once only.
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void getBookTest() {
        // 1. SETUP
        // Create a new Book
        Book book = Book.builder().title("Learn Java in One Hour").author("Hou Siew, Lay").genre("Programming").quantity(5).availability(true).build();

        int bookId = 1;

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        // 2.EXECUTE
        Book retrievedBook = bookService.getBook(bookId);

        // 3. ASSERT
        assertEquals(book, retrievedBook);
    }


    @Test
    void testGetBookNotFound() {
        int bookId = 5354;
        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.getBook(bookId));
    }
    
    
}
