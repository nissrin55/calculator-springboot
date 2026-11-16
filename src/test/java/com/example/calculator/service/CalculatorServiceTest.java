
package com.example.calculator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    CalculatorService service = new CalculatorService();

    @Test
    void testAddition() {
        assertEquals(5.0, service.add(2, 3));
    }

    @Test
    void testSoustraction() {
        assertEquals(1.0, service.subtract(3, 2));
    }

    @Test
    void testMultiplication() {
        assertEquals(6.0, service.multiply(2, 3));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, service.divide(6, 3));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(
            IllegalArgumentException.class,
            () -> service.divide(10, 0)
        );
    }
}
