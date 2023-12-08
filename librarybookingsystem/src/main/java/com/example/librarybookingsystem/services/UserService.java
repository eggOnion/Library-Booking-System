package com.example.librarybookingsystem.services;
import java.util.ArrayList;

import com.example.librarybookingsystem.entities.User;


public interface UserService {

    //Perform CRUD Operations:
    
    User createUser(User user);

    User getUser(int id);

    ArrayList<User> getAllUsers();

    User updateUser(int id, User user);

    void deleteUser(int id);

    ArrayList<User> searchUsers(String firstName);       //switch to search by username later
    
}

    

