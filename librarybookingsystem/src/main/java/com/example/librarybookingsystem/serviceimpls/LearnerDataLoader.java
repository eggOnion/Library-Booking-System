package com.example.librarybookingsystem.serviceimpls;


import org.springframework.stereotype.Component;
import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.repositories.LearnerRepository;

import jakarta.annotation.PostConstruct;

@Component
public class LearnerDataLoader {

    private LearnerRepository learnerRepository;

    public LearnerDataLoader(LearnerRepository learnerRepository) {
        this.learnerRepository = learnerRepository;
    }

    @PostConstruct
    public void loadData() {
        learnerRepository.deleteAll();

        learnerRepository.save(new Learner("John", "Wick", "johnwick@continental.com", "99102134"));
        learnerRepository.save(new Learner("Winston", "Scott", "winstonscott@continental.com", "99102134"));
        learnerRepository.save(new Learner("Viggo", "Tarasov", "viggotarasov@continental.com", "99102134"));
    }
    
}
