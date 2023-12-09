package com.example.librarybookingsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.librarybookingsystem.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUser(String firstName);    
}
