package com.example.librarybookingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.librarybookingsystem.entities.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitle(String title);
}
