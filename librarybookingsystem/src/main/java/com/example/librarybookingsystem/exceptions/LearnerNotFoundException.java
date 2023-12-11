package com.example.librarybookingsystem.exceptions;

public class LearnerNotFoundException extends RuntimeException {
  public LearnerNotFoundException(String id){
    super("Could not find learner with id: " + id + ".");
  }
    
}
