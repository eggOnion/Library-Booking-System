package com.example.librarybookingsystem;
import java.util.UUID; //added this import for UUID

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // dont use generatedvalue because using random UUID

    @Column(name = "id")
    private String id; //change from int to String

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
    @NotNull(message = "Quantity is mandatory")
    private int quantity;

    @Column(name = "availability")
    private boolean availability;

    public Book() {
        this.id = UUID.randomUUID().toString(); //id will be randomUUID
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
