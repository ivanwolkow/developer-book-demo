package com.example.demo.designpatterns.structural.flyweight;

public class StateObject {

    private final String innerState;

    public StateObject(String innerState) {
        this.innerState = innerState;
    }

    public String getInnerState() {
        return innerState;
    }
}
