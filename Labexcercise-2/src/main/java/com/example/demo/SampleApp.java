package com.example.demo;

import java.util.List;   // Unused import (PMD violation)
import java.util.ArrayList;

public class SampleApp {

    private int count;   //  Unused field

    public static void main(String[] args) {
        SampleApp app = new SampleApp();
        app.sayHello();
    }

    public void sayHello() {
        int unusedVariable = 10;   // Unused local variable
        System.out.println("Hello PMD!");
    }
}
