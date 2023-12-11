package com.example.librarybookingsystem.services;
import java.util.ArrayList;

import com.example.librarybookingsystem.entities.Learner;


public interface LearnerService {

    //Perform CRUD Operations:
    
    Learner createLearner(Learner learner);

    Learner getLearner(String id);

    ArrayList<Learner> getAllLearners();

    Learner updateLearner(String id, Learner learner);

    void deleteLearner(String id);

    ArrayList<Learner> searchLearner(String email);       //switch to search by username later
    
}

    

