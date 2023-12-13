package com.example.librarybookingsystem.services;
import java.util.ArrayList;

import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.entities.Learner.LearnerBuilder;


public interface LearnerService {

    //Perform CRUD Operations:
    
    Learner createLearner(Learner learner);

    Learner getLearner(int id);

    ArrayList<Learner> getAllLearners();

    Learner updateLearner(int id, Learner learner);

    void deleteLearner(int id);

    ArrayList<Learner> searchLearner(String email); 
}

