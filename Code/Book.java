package sg.ntu.edu.simplecrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
