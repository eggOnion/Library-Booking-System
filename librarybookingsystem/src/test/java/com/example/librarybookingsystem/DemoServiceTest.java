package com.example.librarybookingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoServiceTest {
    
    DemoService demoService;

    @BeforeEach
    public void init() {
        System.out.println("Before each test");
        demoService = new DemoService();
    } 

    @Test
    public void testAdd(){
        // 1. SETUP
        // Create the instance of the class that we want to test
        // DemoService demoService = new DemoService();

        // define the expected result
        // int expectedResult = 8;

        // 2.Execute
        // Call the method we want to test
        // int actualResult = demoService.add(3,5);

        // 3. ASSERT
        // Compare the actual result with the expected result
        assertEquals(8, demoService.add(3,5), "3 + 5 should be 8");
    }

}

