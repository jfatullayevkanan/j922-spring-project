package com.example.j922springproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    void testSumSuccess() {
        assertEquals(calculatorService.findMax(8, 6), 8);
        assertEquals(calculatorService.findMax(4, 7), 7);
        assertEquals(calculatorService.findMax(4, 4), 4);
    }
}
