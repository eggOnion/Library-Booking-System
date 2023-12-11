package com.example.librarybookingsystem.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarybookingsystem.entities.LoanPeriod;
import com.example.librarybookingsystem.services.LoanPeriodService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loans")
public class LoanPeriodController {
    
    private LoanPeriodService loanPeriodService;

    public LoanPeriodController(LoanPeriodService loanPeriodService) {
        this.loanPeriodService = loanPeriodService;
    }

    @PostMapping("")
    public ResponseEntity<LoanPeriod> createLoanPeriod(@Valid @RequestBody LoanPeriod loanPeriod) {
        LoanPeriod newLoanPeriod = loanPeriodService.createLoanPeriod(loanPeriod);
        return new ResponseEntity<>(newLoanPeriod, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<LoanPeriod>> getAllLoanPeriods() {
        ArrayList<LoanPeriod> allLoanPeriods = loanPeriodService.getAllLoanPeriods();
        return new ResponseEntity<>(allLoanPeriods, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<LoanPeriod> getLoanPeriod(@PathVariable int id) {
        LoanPeriod findLoanPeriod = loanPeriodService.getLoanPeriod(id);
        return new ResponseEntity<>(findLoanPeriod, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanPeriod> updateLoanPeriod(@PathVariable int id, @RequestBody LoanPeriod loanPeriod) {
        LoanPeriod updateLoanPeriod = loanPeriodService.updateLoanPeriod(id, loanPeriod);
        return new ResponseEntity<>(updateLoanPeriod, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LoanPeriod> deleteLoanPeriod(@PathVariable int id) {
        loanPeriodService.deleteLoanPeriod(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
