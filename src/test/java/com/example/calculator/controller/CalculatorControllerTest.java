
package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService service;

    @Test
    void testAddEndpoint() throws Exception {

        when(service.add(2, 3)).thenReturn(5.0);

        mockMvc.perform(get("/api/calculator/add")
                .param("a", "2")
                .param("b", "3"))
            .andExpect(status().isOk())
            .andExpect(content().string("5.0"));
    }

    @Test
    void testSubtractEndpoint() throws Exception {

        when(service.subtract(3, 2)).thenReturn(1.0);

        mockMvc.perform(get("/api/calculator/subtract")
                .param("a", "3")
                .param("b", "2"))
            .andExpect(status().isOk())
            .andExpect(content().string("1.0"));
    }

    @Test
    void testMultiplyEndpoint() throws Exception {

        when(service.multiply(2, 3)).thenReturn(6.0);

        mockMvc.perform(get("/api/calculator/multiply")
                .param("a", "2")
                .param("b", "3"))
            .andExpect(status().isOk())
            .andExpect(content().string("6.0"));
    }

    @Test
    void testDivideEndpoint() throws Exception {

        when(service.divide(6, 3)).thenReturn(2.0);

        mockMvc.perform(get("/api/calculator/divide")
                .param("a", "6")
                .param("b", "3"))
            .andExpect(status().isOk())
            .andExpect(content().string("2.0"));
    }
}
