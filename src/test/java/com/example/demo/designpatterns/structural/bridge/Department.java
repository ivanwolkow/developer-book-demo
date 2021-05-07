package com.example.demo.designpatterns.structural.bridge;

public abstract class Department {

    protected Developer developer;

    public Department(Developer developer) {
        this.developer = developer;
    }

    abstract void doJob();
}
