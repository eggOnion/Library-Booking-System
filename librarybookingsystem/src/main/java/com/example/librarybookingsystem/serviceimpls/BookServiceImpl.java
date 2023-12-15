package com.example.librarybookingsystem.serviceimpls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.librarybookingsystem.entities.Book;
import com.example.librarybookingsystem.exceptions.BookNotFoundException;
import com.example.librarybookingsystem.repositories.BookRepository;
import com.example.librarybookingsystem.services.BookService;

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

    // @Override
    // public Book createBook(Book book) {
    // Book newBook = bookRepository.save(book);
    // return newBook;
    // }

    @Override
    public Book createBook(Book book) {
        List<Book> existingBooks = bookRepository.findByTitle(book.getTitle());

        if (!existingBooks.isEmpty()) {
            for (Book existingBook : existingBooks) {
                if (existingBook.getAuthor().equals(book.getAuthor())
                        && existingBook.getGenre().equals(book.getGenre())) {
                    int updatedQty = existingBook.getQuantity() + book.getQuantity();
                    existingBook.setQuantity(updatedQty);

                    if (updatedQty > 0) {
                        existingBook.setAvailability(true);
                    }

                    bookRepository.save(existingBook);
                    return existingBook;
                }
            }
        }
        if (book.getQuantity() > 0) {
            book.setAvailability(true);
        }

        Book newBook = bookRepository.save(book);
        return newBook;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return (ArrayList<Book>) allBooks;
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book updateBook(int id, Book book) {
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

    // @Override
    // public Book borrowBook(int book_id, int learner_id) {
    // Book bookToBorrow = bookRepository.findById(book_id).get();
    // Learner learnerThatBorrow = learnerRepository.findById(learner_id).get();

    // if(bookToBorrow != null && learnerThatBorrow != null) {
    // loanPeriod.setLearner(learnerThatBorrow);
    // loanPeriod.setBook(bookToBorrow);
    // }
    // return null;
    // }

    @Override
    public void deleteBook(int id) {
        Optional<Book> bookOptional =bookRepository.findById(id);
        if(bookOptional.isPresent()){
            bookRepository.deleteById(id);
        } else {
            throw new BookNotFoundException(id);
        }
    }

}
