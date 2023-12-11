package com.example.librarybookingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarybookingsystem.entities.LoanPeriod;

import java.util.List;

public interface LoanPeriodRepository extends JpaRepository<LoanPeriod, Integer> {
    List<LoanPeriod> findbyId(int id);
}
