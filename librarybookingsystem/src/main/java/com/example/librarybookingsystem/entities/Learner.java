package com.example.librarybookingsystem.entities;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
//import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "learner")
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    @Email(message = "email should be a valid email address")
    @Column(name = "email", unique = true)
    private String email;

    @Digits(fraction = 0, integer = 9, message = "contact number cannot have alphabets")
    @Column(name = "contact_num", nullable = false)
    @Size(min = 8, max = 8, message = "contact number must have 8 digits")
    private String contact_num;

    @JsonManagedReference(value = "learner-loan")
    @OneToMany(mappedBy = "learner", cascade = CascadeType.ALL)
    private List<LoanPeriod> loanPeriod;

    public Learner() {
        // parameterless constructor - Default Constructor
    }

    public Learner(String firstName, String lastName, String email, String contact_num) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contact_num = contact_num;
    }
}
