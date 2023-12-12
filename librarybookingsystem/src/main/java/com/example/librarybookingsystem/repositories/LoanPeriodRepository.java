package com.example.librarybookingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.librarybookingsystem.entities.LoanPeriod;

// @Repository
// public interface LoanPeriodRepository extends JpaRepository<LoanPeriod, Integer> {
//     List<LoanPeriod> findbyId(int id);
// }


@Repository
public interface LoanPeriodRepository extends JpaRepository<LoanPeriod, Integer> {
    List<LoanPeriod> findByLoanStatus(String loanStatus);
}
