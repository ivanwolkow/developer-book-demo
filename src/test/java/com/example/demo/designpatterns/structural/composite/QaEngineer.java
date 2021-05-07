package com.example.demo.designpatterns.structural.composite;

public class QaEngineer extends AbstractWorkingUnit {
    public QaEngineer(String name) {
        super(name);
    }

    @Override
    public void doJob() {
        System.out.println(name + ": testing software");
    }
}
