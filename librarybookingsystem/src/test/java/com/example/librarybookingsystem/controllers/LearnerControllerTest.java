package com.example.librarybookingsystem.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.librarybookingsystem.entities.Learner;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LearnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Get Learner by Id")
    @Test
    @WithMockUser
    public void getLearnerById() throws Exception {
        // Step 1: Build a GET request to /learners/1
        RequestBuilder request = MockMvcRequestBuilders.get("/learners/1");

        // Step 2: Perform the request, get the response and assert
        mockMvc.perform(request)
                // Assert that the status code is 200
                .andExpect(status().isOk())
                // Assert that the content type is JSON
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // Assert that the id returned is 1
                .andExpect(jsonPath("$.id").value(1));
    }

    @DisplayName("Get all Learners")
    @Test
    @WithMockUser
    public void getAllLearnersTest() throws Exception {
        // Step 1: SETUP
        RequestBuilder request = MockMvcRequestBuilders.get("/learners");

        // Step 2 & 3: EXECUTE and ASSERT
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(3));
    }


    // @DisplayName("Create a Learner")
    // @Test
    // @WithMockUser
    // public void validLearnerCreationTest() throws Exception {
    //     Learner learner = Learner.builder().firstName("Andy").lastName("Lee").email("andylee@rmail.com")
    //     .contact_num("99225588").build();

    //     String newLearnerkAsJSON = objectMapper.writeValueAsString(learner);

    //     RequestBuilder request = MockMvcRequestBuilders.post("/learners").contentType(MediaType.APPLICATION_JSON)
    //     .content(newLearnerkAsJSON);

    //     mockMvc.perform(request)
    //         .andExpect(status().isCreated())
    //         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    //         .andExpect(jsonPath("$.fistName").value("Andy"))
    //         .andExpect(jsonPath("$.lastName").value("Lee"))
    //         .andExpect(jsonPath("$.email").value("andylee@email.com"))
    //         .andExpect(jsonPath("$.contact_num").value("99225588"));

    // }
    
}
