package com.example.demo.designpatterns.structural.composite;

public class Developer extends AbstractWorkingUnit {
    public Developer(String name) {
        super(name);
    }

    @Override
    public void doJob() {
        System.out.println(name + ": building software");
    }
}
