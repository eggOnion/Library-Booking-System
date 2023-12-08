package com.example.librarybookingsystem.exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(int id){
    super("Could not find user with id: " + id + ".");
  }
    
}
