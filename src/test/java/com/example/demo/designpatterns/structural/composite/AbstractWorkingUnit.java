package com.example.demo.designpatterns.structural.composite;

public abstract class AbstractWorkingUnit implements WorkingUnit {
    protected String name;

    public AbstractWorkingUnit(String name) {
        this.name = name;
    }

}
