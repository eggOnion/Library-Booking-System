package com.example.librarybookingsystem.services;

import java.util.ArrayList;

import com.example.librarybookingsystem.entities.LoanPeriod;

public interface LoanPeriodService {
    
    LoanPeriod createLoanPeriod(LoanPeriod loan);

    LoanPeriod getLoanPeriod(int id);

    ArrayList<LoanPeriod> getAllLoanPeriods();

    LoanPeriod updateLoanPeriod(int id, LoanPeriod loanPeriod);

    void deleteLoanPeriod(int id);

    ArrayList<LoanPeriod> searchLoanStatus(String loanStatus);

}
