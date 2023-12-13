package com.example.librarybookingsystem.services;

import java.util.ArrayList;

import com.example.librarybookingsystem.entities.Book;

public interface BookService {

   Book createBook(Book book);

   Book getBook(int id);

   ArrayList<Book> getAllBooks();

   Book updateBook(int id, Book book);

   // Book borrowBook(int book_id, int learner_id);

   void deleteBook(int id);

   ArrayList<Book> searchBooks(String title);
}
