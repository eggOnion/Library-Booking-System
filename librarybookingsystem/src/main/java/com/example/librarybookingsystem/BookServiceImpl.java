package com.example.librarybookingsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ArrayList<Book> searchBooks(String title) {
        List<Book> findBooks = bookRepository.findByTitle(title);
        return (ArrayList<Book>) findBooks;
    }

    @Override
    public Book createBook(Book book) {
        Book newBook = bookRepository.save(book);
        return newBook;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return (ArrayList<Book>) allBooks;
    }

    @Override
    public Book getBook(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book updateBook(String id, Book book) {
        Book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setGenre(book.getGenre());
        bookToUpdate.setQuantity(book.getQuantity());

        if (bookToUpdate.getQuantity() == 0) {
            bookToUpdate.setAvailability(false);
        } else {
            bookToUpdate.setAvailability(true);
        }

        return bookRepository.save(bookToUpdate);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

}
