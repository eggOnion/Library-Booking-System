package com.example.librarybookingsystem.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonBackReference(value = "learner-loan")
    @ManyToOne
    @JoinColumn(name = "learner_id", referencedColumnName = "id", nullable = false)
    @JoinColumn(name = "learner_firstname", referencedColumnName = "first_name", nullable = false)
    @JoinColumn(name = "learner_lastname", referencedColumnName = "last_name", nullable = false)
    private Learner learner;

    @JsonBackReference(value = "book-loan")
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    @JoinColumn(name = "book_title", referencedColumnName = "title", nullable = false)
    private Book book;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "end_time")
    private LocalDate endTime;

    @Column(name = "loan_status")
    private String loanStatus;

    public LoanPeriod() {

    }

    public LoanPeriod(Learner learner, Book book, LocalDate startTime, LocalDate endTime, String loanStatus) {
        this();
        this.learner = learner;
        this.book = book;
        this.startTime = startTime;
        this.endTime = endTime;
        this.loanStatus = loanStatus;
    }

}
