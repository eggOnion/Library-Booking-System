package com.example.librarybookingsystem.serviceimpls;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.entities.LoanPeriod;
import com.example.librarybookingsystem.exceptions.LearnerNotFoundException;
import com.example.librarybookingsystem.exceptions.LoanPeriodNotFoundException;
import com.example.librarybookingsystem.repositories.LearnerRepository;
import com.example.librarybookingsystem.repositories.LoanPeriodRepository;
import com.example.librarybookingsystem.services.LoanPeriodService;

@Service
public class LoanPeriodServiceImpl implements LoanPeriodService {

    private LoanPeriodRepository loanPeriodRepository;

    public LoanPeriodServiceImpl(LoanPeriodRepository loanPeriodRepository) {
        this.loanPeriodRepository = loanPeriodRepository;
    }

    @Override
    public LoanPeriod createLoanPeriod(LoanPeriod loanPeriod) {
        LoanPeriod newLoanPeriod = loanPeriodRepository.save(loanPeriod);
        return newLoanPeriod;
    }

    @Override
    public LoanPeriod getLoanPeriod(int id) {
        return loanPeriodRepository.findById(id).orElseThrow(() -> new LoanPeriodNotFoundException(id));
    }

    @Override
    public ArrayList<LoanPeriod> getAllLoanPeriods() {
        List<LoanPeriod> allLoanPeriod = loanPeriodRepository.findAll();
        return (ArrayList<LoanPeriod>) allLoanPeriod;
    }


    // for now this method will just update loanStatus to RETURNED
    @Override
    public LoanPeriod updateLoanPeriod(int id, LoanPeriod loanPeriod) {

        LoanPeriod loanPeriodToUpdate = loanPeriodRepository.findById(id).get();
        loanPeriodToUpdate.setLoanStatus("RETURNED");

        return loanPeriodRepository.save(loanPeriodToUpdate);    
    }

    @Override
    public void deleteLoanPeriod(int id) {
        loanPeriodRepository.deleteById(id);
    }

    @Override
    public ArrayList<LoanPeriod> searchLoanStatus(String loanStatus) {
        List<LoanPeriod> findLoanPeriod = loanPeriodRepository.findByLoanStatus(loanStatus);
        return (ArrayList<LoanPeriod>) findLoanPeriod;        
    } 
    

    // @Override
    // public ArrayList<Learner> searchLearner(String email) {
    //     List<Learner> findLearner = learnerRepository.findByEmail(email);
    //     return (ArrayList<Learner>) findLearner;        
    // } 
    
}
