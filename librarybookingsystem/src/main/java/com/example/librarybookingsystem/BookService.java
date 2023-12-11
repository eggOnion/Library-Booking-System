package com.example.librarybookingsystem;

import java.util.ArrayList;

public interface BookService {

   Book createBook(Book book);

   Book getBook(String id);

   ArrayList<Book> getAllBooks();

   Book updateBook(String id, Book book);

   void deleteBook(String id);

   ArrayList<Book> searchBooks(String title);
}
