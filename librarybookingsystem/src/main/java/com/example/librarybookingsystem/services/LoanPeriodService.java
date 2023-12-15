package com.example.librarybookingsystem.services;

import java.util.ArrayList;

import com.example.librarybookingsystem.entities.LoanPeriod;

public interface LoanPeriodService {

    LoanPeriod createLoanPeriod(int learner_id, int book_id);

    LoanPeriod getLoanPeriod(int id);

    ArrayList<LoanPeriod> getAllLoanPeriods();

    // LoanPeriod updateLoanPeriod(int id, LoanPeriod loanPeriod);

    LoanPeriod returnLoanPeriod(int id);

    void deleteLoanPeriod(int id);

    ArrayList<LoanPeriod> searchLoanStatus(String loanStatus);

}
