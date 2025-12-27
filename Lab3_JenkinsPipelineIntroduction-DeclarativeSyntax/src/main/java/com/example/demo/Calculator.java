package com.example.demo;

public class Calculator {

    public int add(int a, int b) {
        int unused = 10;   // PMD: UnusedLocalVariable
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            return 0;      // PMD: Avoid returning magic values
        }
        return a / b;
    }
}
