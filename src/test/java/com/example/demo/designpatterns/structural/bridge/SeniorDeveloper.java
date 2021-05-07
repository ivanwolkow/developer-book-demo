package com.example.demo.designpatterns.structural.bridge;

public class SeniorDeveloper implements Developer{

    @Override
    public void work() {
        System.out.println("Senior: working smart");
    }
}
