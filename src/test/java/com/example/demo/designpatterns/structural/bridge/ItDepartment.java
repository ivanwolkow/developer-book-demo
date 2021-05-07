package com.example.demo.designpatterns.structural.bridge;

public class ItDepartment extends Department{

    public ItDepartment(Developer developer) {
        super(developer);
    }

    @Override
    void doJob() {
        developer.work();
    }
}
