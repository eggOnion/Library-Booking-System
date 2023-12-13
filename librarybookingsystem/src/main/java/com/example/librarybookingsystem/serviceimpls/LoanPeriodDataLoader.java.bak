package com.example.librarybookingsystem.serviceimpls;

import jakarta.annotation.PostConstruct;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.librarybookingsystem.entities.LoanPeriod;
import com.example.librarybookingsystem.repositories.LoanPeriodRepository;

@Component
public class LoanPeriodDataLoader {

    private LoanPeriodRepository loanRepository;

    public LoanPeriodDataLoader(LoanPeriodRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostConstruct
    public void loadData() {
        loanRepository.deleteAll();

        loanRepository.save(new LoanPeriod(1,1,LocalDate.parse("2023-12-01"),LocalDate.parse("2023-12-06"), "RETURNED"));
        loanRepository.save(new LoanPeriod(2,2,LocalDate.parse("2023-12-01"),LocalDate.parse("2023-12-07"), "OVERDUE"));
        loanRepository.save(new LoanPeriod(3,3,LocalDate.parse("2023-12-10"),LocalDate.parse("2023-12-17"), "BORROWED"));
    }
    
}
