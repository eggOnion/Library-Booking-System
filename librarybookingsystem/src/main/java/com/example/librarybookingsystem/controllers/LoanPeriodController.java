package com.example.librarybookingsystem.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarybookingsystem.entities.Book;
import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.entities.LoanPeriod;
import com.example.librarybookingsystem.repositories.LoanPeriodRepository;
import com.example.librarybookingsystem.services.BookService;
import com.example.librarybookingsystem.services.LearnerService;
import com.example.librarybookingsystem.services.LoanPeriodService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loanstatus")
public class LoanPeriodController {

    private LoanPeriodService loanPeriodService;
    private LearnerService learnerService;
    private BookService bookService;
    private LoanPeriod loanPeriod;

    public LoanPeriodController(LoanPeriodService loanPeriodService, LearnerService learnerService,
            BookService bookService) {
        this.loanPeriodService = loanPeriodService;
        this.learnerService = learnerService;
        this.bookService = bookService;
    }

    @PostMapping(path = { "", "/" })
    public ResponseEntity<LoanPeriod> createLoanPeriod(@Valid @RequestBody LoanPeriod loanPeriod) {
        LoanPeriod newLoanPeriod = loanPeriodService.createLoanPeriod(loanPeriod);
        return new ResponseEntity<>(newLoanPeriod, HttpStatus.OK);
    }

    @GetMapping(path = { "", "/" })
    public ResponseEntity<ArrayList<LoanPeriod>> getAllLoanPeriods() {
        ArrayList<LoanPeriod> allLoanPeriods = loanPeriodService.getAllLoanPeriods();
        return new ResponseEntity<>(allLoanPeriods, HttpStatus.OK);
    }

    @GetMapping(path = { "/{id}", "/{id}/" })
    public ResponseEntity<LoanPeriod> getLoanPeriod(@PathVariable int id) {
        LoanPeriod findLoanPeriod = loanPeriodService.getLoanPeriod(id);
        return new ResponseEntity<>(findLoanPeriod, HttpStatus.OK);
    }

    @PutMapping(path = { "/{id}", "/{id}/" })
    public ResponseEntity<LoanPeriod> updateLoanPeriod(@PathVariable int id, @RequestBody LoanPeriod loanPeriod) {
        LoanPeriod updateLoanPeriod = loanPeriodService.updateLoanPeriod(id, loanPeriod);
        return new ResponseEntity<>(updateLoanPeriod, HttpStatus.OK);
    }

    @DeleteMapping(path = { "/{id}", "/{id}/" })
    public ResponseEntity<LoanPeriod> deleteLoanPeriod(@PathVariable int id) {
        loanPeriodService.deleteLoanPeriod(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/borrow/{learner_id}/{book_id}")
    public ResponseEntity<LoanPeriod> createLoanPeriodBorrow(@PathVariable int learner_id, @PathVariable int book_id) {
        Learner learner = learnerService.getLearner(learner_id);
        Book book = bookService.getBook(book_id);

        if (learner == null || book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        LoanPeriod loanPeriod = new LoanPeriod(learner, book, LocalDate.now(), LocalDate.now().plusDays(30), "BORROWED");

        loanPeriodService.createLoanPeriod(loanPeriod);
        bookService.updateBook(book_id, book);

        return new ResponseEntity<>(loanPeriod, HttpStatus.CREATED);
    }

    @PostMapping("/return/{learner_id}/{book_id}")
    public ResponseEntity<LoanPeriod> createLoanPeriodReturn(@PathVariable int learner_id, @PathVariable int book_id) {
        Learner learner = learnerService.getLearner(learner_id);
        Book book = bookService.getBook(book_id);

        if (learner == null || book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() + 1);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        LoanPeriod loanPeriod = new LoanPeriod(learner, book, LocalDate.now(), LocalDate.now().plusDays(30), "RETURNED");

        loanPeriodService.createLoanPeriod(loanPeriod);
        bookService.updateBook(book_id, book);

        return new ResponseEntity<>(loanPeriod, HttpStatus.CREATED);
    }

    

    // @PostMapping(path={"/user_id/"})
    // public ResponseEntity someMethod(@PathVariable int user_id @PathVariable int
    // book_id) {

    // }
}
