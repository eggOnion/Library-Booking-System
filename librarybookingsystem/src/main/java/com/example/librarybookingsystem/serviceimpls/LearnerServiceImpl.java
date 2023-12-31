package com.example.librarybookingsystem.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.exceptions.LearnerNotFoundException;
import com.example.librarybookingsystem.repositories.LearnerRepository;
import com.example.librarybookingsystem.services.LearnerService;


@Service
public class LearnerServiceImpl implements LearnerService {

    private LearnerRepository learnerRepository;    

    @Autowired
    public LearnerServiceImpl(LearnerRepository learnerRepository) {
        this.learnerRepository = learnerRepository;
    }

    @Override
    public Learner createLearner(Learner learner) {
        Learner newUser = learnerRepository.save(learner);
        return newUser;
    }

    @Override
    public Learner getLearner(int id) {
        return learnerRepository.findById(id).orElseThrow(() -> new LearnerNotFoundException(id));
    }

    @Override
    public ArrayList<Learner> getAllLearners() {
        List<Learner> allLearners = learnerRepository.findAll();
        return (ArrayList<Learner>) allLearners;
    }

    @Override
    public Learner updateLearner(int id, Learner learner) {
  
        Learner learnerToUpdate = learnerRepository.findById(id).get();
        learnerToUpdate.setFirstName(learner.getFirstName());        
        learnerToUpdate.setLastName(learner.getLastName());
        learnerToUpdate.setEmail(learner.getEmail());
        learnerToUpdate.setContact_num(learner.getContact_num());
        return learnerRepository.save(learnerToUpdate);    
    }

    @Override
    public void deleteLearner(int id) {
        learnerRepository.deleteById(id);
    }

    @Override
    public ArrayList<Learner> searchLearner(String email) {
        List<Learner> findLearner = learnerRepository.findByEmail(email);
        return (ArrayList<Learner>) findLearner;        
    }     
}


