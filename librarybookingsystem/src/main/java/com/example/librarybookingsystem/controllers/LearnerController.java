package com.example.librarybookingsystem.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.services.LearnerService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/learners")
public class LearnerController {

    private LearnerService learnerService;

    public LearnerController(LearnerService learnerService) {
        this.learnerService = learnerService;
    }

    @PostMapping(path={"","/"})
    public ResponseEntity<Learner> createLearner(@Valid @RequestBody Learner learner) {
        Learner newLearner = learnerService.createLearner(learner);
        return new ResponseEntity<>(newLearner, HttpStatus.CREATED);
    }

    @GetMapping(path={"","/"})
    public ResponseEntity<ArrayList<Learner>> getAllLearners() {
        ArrayList<Learner> allLearners = learnerService.getAllLearners();
        return new ResponseEntity<>(allLearners, HttpStatus.OK);
    }

    @GetMapping(path = {"/{id}","/{id}/"})
    public ResponseEntity<Learner> getLearner(@PathVariable int id) {
        Learner findLearner = learnerService.getLearner(id);
        return new ResponseEntity<>(findLearner, HttpStatus.OK);
    }

    @GetMapping(path={"/search","/search/"})    //search?email=
    public ResponseEntity<ArrayList<Learner>> searchLearners(@RequestParam String email) {
        ArrayList<Learner> foundLearner = learnerService.searchLearner(email);
        return new ResponseEntity<>(foundLearner, HttpStatus.OK);
    }

    @PutMapping(path = {"/{id}","/{id}/"})
    public ResponseEntity<Learner> updateLearner(@PathVariable int id, @Valid @RequestBody Learner learner) {
        Learner updateLearner = learnerService.updateLearner(id, learner);
        return new ResponseEntity<>(updateLearner, HttpStatus.OK);
    }

    @DeleteMapping(path = {"/{id}","/{id}/"})
    public ResponseEntity<Learner> deleteLearner(@PathVariable int id) {
        learnerService.deleteLearner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
