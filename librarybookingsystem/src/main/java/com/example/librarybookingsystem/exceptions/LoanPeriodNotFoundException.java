package com.example.librarybookingsystem.exceptions;

public class LoanPeriodNotFoundException extends RuntimeException {
    public LoanPeriodNotFoundException(int id) {
        super("Could not find loan with id: " + id + ".");
    }
}
