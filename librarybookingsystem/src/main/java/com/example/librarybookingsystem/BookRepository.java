package com.example.librarybookingsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, java.lang.String> {  //change from Integer to String
    List<Book> findByTitle(String title);
}
