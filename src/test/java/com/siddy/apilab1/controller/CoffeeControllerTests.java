package com.siddy.apilab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc // Enable and configure auto-config of MockMVC
@SpringBootTest
public class CoffeeControllerTests {

    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testCoffeeLover() throws Exception{
        String expectedContent = "I love coffee!!";

        this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffeelover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));

    }

    @Test
    public void testCoffee() throws Exception {
        int expectedId = 1;
        String expectedCoffee = "latte";

        this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedCoffee));
    }

    @Test
    public void testCoffeeFlatWhite() throws Exception {
        int expectedId = 1;
        String expectedCoffee = "Flat White";

        this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffee?name=Flat White"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedCoffee));
    }
}
