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

import com.example.librarybookingsystem.entities.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Get book by Id")
    @Test
    @WithMockUser
    public void getBookById() throws Exception {
        // Step 1: Build a GET request to /book/1
        RequestBuilder request = MockMvcRequestBuilders.get("/book/1");

        // Step 2: Perform the request, get the response and assert
        mockMvc.perform(request)
                // Assert that the status code is 200
                .andExpect(status().isOk())
                // Assert that the content type is JSON
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // Assert that the id returned is 1
                .andExpect(jsonPath("$.id").value(1));
    }

    @DisplayName("Get all books")
    @Test
    @WithMockUser
    public void getAllBooksTest() throws Exception {
        // Step 1: SETUP
        RequestBuilder request = MockMvcRequestBuilders.get("/book");

        // Step 2 & 3: EXECUTE and ASSERT
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(3));
    }


    
    @DisplayName("Create a Book")
    @Test
    @WithMockUser
    public void validBookCreationTest() throws Exception {
        Book book = Book.builder().title("Learn Java in One Day").author("Jamie Chan").genre("Programming")
        .quantity(5).availability(true).build();

        String newBookAsJSON = objectMapper.writeValueAsString(book);

        RequestBuilder request = MockMvcRequestBuilders.post("/book").contentType(MediaType.APPLICATION_JSON)
        .content(newBookAsJSON);

        mockMvc.perform(request)
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.title").value("Learn Java in One Day"))
            .andExpect(jsonPath("$.author").value("Jamie Chan"))
            .andExpect(jsonPath("$.genre").value("Programming"))
            .andExpect(jsonPath("$.quantity").value(5))
            .andExpect(jsonPath("$.availability").value(true));
    }


}
