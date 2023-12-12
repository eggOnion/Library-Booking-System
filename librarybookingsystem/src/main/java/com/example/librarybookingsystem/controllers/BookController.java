package com.example.librarybookingsystem.controllers;

import java.util.ArrayList;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarybookingsystem.entities.Book;
import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.services.BookService;


@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path={"","/"})
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping(path={"","/"})
    public ResponseEntity<ArrayList<Book>> getAllBooks() {
        ArrayList<Book> allBooks = bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping(path = {"/{id}","/{id}/"})
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        Book findBook = bookService.getBook(id);
        return new ResponseEntity<>(findBook, HttpStatus.OK);
    }

    @PutMapping(path = {"/{id}","/{id}/"})
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updateBook = bookService.updateBook(id, book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping(path = {"/{id}","/{id}/"})
    public ResponseEntity<Book> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }   
    
    @GetMapping(path={"/search","/search/"})    //search?title=
    public ResponseEntity<ArrayList<Book>> searchBooks(@RequestParam String title) {
        ArrayList<Book> foundBook = bookService.searchBooks(title);
        return new ResponseEntity<>(foundBook, HttpStatus.OK);
    }
}
