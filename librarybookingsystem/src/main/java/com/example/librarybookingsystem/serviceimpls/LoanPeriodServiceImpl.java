package com.example.librarybookingsystem.serviceimpls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.librarybookingsystem.entities.Book;
import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.entities.LoanPeriod;
import com.example.librarybookingsystem.exceptions.LearnerNotFoundException;
import com.example.librarybookingsystem.exceptions.LoanPeriodNotFoundException;
import com.example.librarybookingsystem.repositories.LearnerRepository;
import com.example.librarybookingsystem.repositories.LoanPeriodRepository;
import com.example.librarybookingsystem.services.BookService;
import com.example.librarybookingsystem.services.LearnerService;
import com.example.librarybookingsystem.services.LoanPeriodService;

@Service
public class LoanPeriodServiceImpl implements LoanPeriodService {

    private LoanPeriodRepository loanPeriodRepository;
    private LearnerService learnerService;
    private BookService bookService;

    public LoanPeriodServiceImpl(LoanPeriodRepository loanPeriodRepository, LearnerService learnerService,
            BookService bookService) {
        this.loanPeriodRepository = loanPeriodRepository;
        this.learnerService = learnerService;
        this.bookService = bookService;
    }

    @Override
    public LoanPeriod createLoanPeriod(int learner_id, int book_id) {
        Learner learner = learnerService.getLearner(learner_id);
        Book book = bookService.getBook(book_id);

        if (learner == null || book == null) {
            return null;
        }

        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
        } else {
            return null;
        }

        LoanPeriod loanPeriod = new LoanPeriod(learner, book, LocalDate.now(), LocalDate.now().plusDays(30),
                "BORROWED");

        loanPeriodRepository.save(loanPeriod);
        bookService.updateBook(book_id, book);

        return loanPeriod;
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
    // @Override
    // public LoanPeriod updateLoanPeriod(int id, LoanPeriod loanPeriod) {

    //     LoanPeriod loanPeriodToUpdate = loanPeriodRepository.findById(id).get();
    //     loanPeriodToUpdate.setLoanStatus("RETURNED");

    //     return loanPeriodRepository.save(loanPeriodToUpdate);
    // }

    @Override
    public void deleteLoanPeriod(int id) {
        loanPeriodRepository.deleteById(id);
    }

    @Override
    public ArrayList<LoanPeriod> searchLoanStatus(String loanStatus) {
        List<LoanPeriod> findLoanPeriod = loanPeriodRepository.findByLoanStatus(loanStatus);
        return (ArrayList<LoanPeriod>) findLoanPeriod;
    }

    @Override
    public LoanPeriod returnLoanPeriod(int id) {

        LoanPeriod existingLoanPeriod = loanPeriodRepository.findById(id)
                .orElseThrow(() -> new LoanPeriodNotFoundException(id));

        if (LocalDate.now().isBefore(existingLoanPeriod.getEndTime())) {
            existingLoanPeriod.setLoanStatus("RETURNED");
        } else if (!existingLoanPeriod.getLoanStatus().equals("RETURNED")) {
            existingLoanPeriod.setLoanStatus("OVERDUE");
        }

        Book book = existingLoanPeriod.getBook();
        book.setQuantity(book.getQuantity() + 1);

        loanPeriodRepository.save(existingLoanPeriod);
        bookService.updateBook(book.getId(), book);

        return existingLoanPeriod;
    }

}
