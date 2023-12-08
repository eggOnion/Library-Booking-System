package com.example.librarybookingsystem;

public class BookNotFoundException extends RuntimeException {
    BookNotFoundException(int id) {
        super("Cound not find book with id: " + id + ".");
    }
}
