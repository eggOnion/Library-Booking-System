package com.example.librarybookingsystem.serviceimpls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.exceptions.LearnerNotFoundException;
import com.example.librarybookingsystem.repositories.LearnerRepository;

@SpringBootTest
public class LearnerServiceImplTest {

    @Mock
    private LearnerRepository learnerRepository;

    @InjectMocks
    LearnerServiceImpl learnerService;

    @Test
    public void createLearnerTest() {

        // 1. SETUP
        // Create a new Learner
        
        Learner learner = Learner.builder().firstName("Andy").lastName("Lee").email("andylee@email.com").contact_num("99225588").build();

        // mock the save method of the Book repository
        when((learnerRepository.save(learner))).thenReturn(learner);

        // 2. EXECUTE
        Learner savedLearner = learnerService.createLearner(learner);

        // 3. ASSERT
        assertEquals(learner, savedLearner, "The saved Learner should be the same as the new Learner.");

        // also verify that the save method of book repository is called once only.
        verify(learnerRepository, times(1)).save(learner);
    }

    @Test
    public void getLearnerTest() {
        // 1. SETUP
        // Create a new Learner
        Learner learner = Learner.builder().firstName("Andy").lastName("Lee").email("andylee@email.com").contact_num("99225588").build();

        int learnerId = 1;

        when(learnerRepository.findById(learnerId)).thenReturn(Optional.of(learner));

        // 2.EXECUTE
        Learner retrievedLearner = learnerService.getLearner(learnerId);

        // 3. ASSERT
        assertEquals(learner, retrievedLearner);
    }


    @Test
    void testGetLearnerNotFound() {
        int learnerId = 250;
        when(learnerRepository.findById(learnerId)).thenReturn(Optional.empty());

        assertThrows(LearnerNotFoundException.class, () -> learnerService.getLearner(learnerId));
    }
    
}
