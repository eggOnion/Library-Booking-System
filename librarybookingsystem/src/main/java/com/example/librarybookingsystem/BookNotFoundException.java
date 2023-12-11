package com.example.librarybookingsystem;

public class BookNotFoundException extends RuntimeException {
    BookNotFoundException(String id) {
        super("Cound not find book with id: " + id + ".");
    }
}
