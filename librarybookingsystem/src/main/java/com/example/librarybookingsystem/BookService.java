package com.example.librarybookingsystem;

import java.util.ArrayList;

public interface BookService {

   Book createBook(Book book);

   Book getBook(int id);

   ArrayList<Book> getAllBooks();

   Book updateBook(int id, Book book);

   void deleteBook(int id);

   ArrayList<Book> searchBooks(String title);
}
