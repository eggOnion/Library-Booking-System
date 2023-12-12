package com.example.librarybookingsystem.serviceimpls;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.example.librarybookingsystem.entities.Book;
import com.example.librarybookingsystem.repositories.BookRepository;

@Component
public class BookDataLoader {

    private BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void loadData() {
        bookRepository.deleteAll();

        bookRepository.save(new Book("The Fellowship of the Ring", "J. R. R. Tolkien", "Fantasy", 2, true));
        bookRepository.save(new Book("Thinking, Fast and Slow", "Daniel Kahneman", "Self Improvement", 2, true));
        bookRepository.save(new Book("True Singapore Ghost Stories", "Russell Lee", "Horror", 1, true));
    }
    
}
