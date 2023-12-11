package com.example.librarybookingsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")

public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Title is mandatory")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Column(name = "author")
    private String author;

    @NotBlank(message = "Genre is mandatory")
    @Column(name = "genre")
    private String genre;

    @Column(name = "quantity")
    @Min(value = 0, message = "Quantity cannot be less than 0")
    @Max(value = 5, message = "Quantity cannot be more than 5")
    @NotNull(message = "Quantity is mandatory")
    private int quantity;

    @Column(name = "availability")
    private boolean availability;

    public Book() {

    }

    public Book(String title, String author, String genre, int quantity, boolean availability) {
        this();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.availability = availability;
    }
}
