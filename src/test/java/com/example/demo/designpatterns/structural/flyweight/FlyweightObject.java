package com.example.demo.designpatterns.structural.flyweight;

public class FlyweightObject {
    private StateObject intrinsicState;
    private int extrinsicState;

    public FlyweightObject(StateObject intrinsicState, int extrinsicState) {
        this.intrinsicState = intrinsicState;
        this.extrinsicState = extrinsicState;
    }


    public StateObject getIntrinsicState() {
        return intrinsicState;
    }

    public void setIntrinsicState(StateObject intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    public int getExtrinsicState() {
        return extrinsicState;
    }

    public void setExtrinsicState(int extrinsicState) {
        this.extrinsicState = extrinsicState;
    }
}
