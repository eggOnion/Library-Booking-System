package com.example.librarybookingsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.librarybookingsystem.entities.Learner;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Integer> {
    List<Learner> findByEmail(String email);    
}
