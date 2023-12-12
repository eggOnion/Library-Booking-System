package com.example.librarybookingsystem.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "loan_period")

public class LoanPeriod {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    // private Learner learner;
    private int learner;

    @JoinColumn(name = "book_id", referencedColumnName = "id")
    // private Book book;
    private int book;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "end_time")
    private LocalDate endTime;

    @Column(name = "loan_status")
    private String loanStatus;   

    public LoanPeriod() {

    }

    
    // public LoanPeriod(Learner learner, Book book, LocalDate startTime, LocalDate endTime, String loanStatus ) {
    public LoanPeriod(int learner, int book, LocalDate startTime, LocalDate endTime, String loanStatus ) {     
        this();
        this.learner = learner ;
        this.book = book;
        this.startTime = startTime;
        this.endTime = endTime;
        this.loanStatus = loanStatus;
    }

}
