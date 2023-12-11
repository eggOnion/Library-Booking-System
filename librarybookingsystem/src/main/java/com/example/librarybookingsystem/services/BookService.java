package com.example.librarybookingsystem.services;

import java.util.ArrayList;

import com.example.librarybookingsystem.entities.Book;

public interface BookService {

   Book createBook(Book book);

   Book getBook(int id);

   ArrayList<Book> getAllBooks();

   Book updateBook(int id, Book book);

   void deleteBook(int id);

   ArrayList<Book> searchBooks(String title);
}
