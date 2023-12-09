package com.example.librarybookingsystem.serviceimpls;

import org.springframework.stereotype.Component;

import com.example.librarybookingsystem.Book;
import com.example.librarybookingsystem.BookRepository;
import com.example.librarybookingsystem.entities.User;
import com.example.librarybookingsystem.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    private BookRepository bookRepository;
    private UserRepository userRepository;

    public DataLoader(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void loadData() {
        bookRepository.deleteAll();
        userRepository.deleteAll();

        bookRepository.save(new Book("The Fellowship of the Ring", "J. R. R. Tolkien", "Fantasy", 2, true));
        bookRepository.save(new Book("Thinking, Fast and Slow", "Daniel Kahneman", "Self Improvement", 2, true));
        bookRepository.save(new Book("True Singapore Ghost Stories", "Russell Lee", "Horror", 1, true));
    
        userRepository.save(new User("John", "Wick", "johnwick@continental.com"));
        userRepository.save(new User("Winston", "Scott", "winstonscott@continental.com"));
        userRepository.save(new User("Viggo", "Tarasov", "viggotarasov@continental.com"));
    
    }
    
}
