package com.example.librarybookingsystem.entities;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.UUID; //added this import for UUID

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="learner")
public class Learner {
    
    @Id

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // dont use generatedvalue because using random UUID

    @Column(name = "id")
    private String id;

    // @NotBlank(message = "Username is mandatory")
    // @Column(name = "username")
    // private String title;

    // @NotBlank(message = "password is mandatory")
    // @Column(name = "password")
    // private String password;

    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "email should be a valid email address")      //change to @Email later
    @Column(name = "email", unique = true)
    private String email;

    @Digits(fraction=0, integer = 9, message = "contact number cannot have alphabets")
    @Column(name = "contact_num", nullable = false)
    @Size(min=8, max=8, message = "contact number must have 8 digits")
    private String contact_num;

    //parameterless constructor - Default Constructor
    public Learner() {
                this.id = UUID.randomUUID().toString(); //id will be randomUUID
    }

    public Learner(String firstName, String lastName, String email, String contact_num){
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contact_num = contact_num;
    }    
}
