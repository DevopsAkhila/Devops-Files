package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorIntegrationTest {

    @Test
    void testAdditionAndDivisionWorkflow() {
        Calculator calc = new Calculator();

        // Step 1: Add two numbers
        int sum = calc.add(10, 5);
        assertEquals(15, sum);

        // Step 2: Divide the result
        int division = calc.divide(sum, 5);
        assertEquals(3, division);

        // Step 3: Combine multiple operations
        int combined = calc.divide(calc.add(6, 4), 2);
        assertEquals(5, combined);
    }

    @Test
    void testDivisionByZeroWorkflow() {
        Calculator calc = new Calculator();

        int result = calc.divide(10, 0);
        assertEquals(0, result);  // Matches your current Calculator behavior
    }
}
