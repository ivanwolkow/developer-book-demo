package com.example.demo.designpatterns.creational.prototype;

/*
    Implementation of prototype pattern (shallow copy)
    Apple class must implement Cloneable interface, otherwise Object.clone throws CloneNotSupportedException
 */
public class Apple implements Cloneable{

    private int[] field1;

    public int[] getField1() {
        return field1;
    }

    public void setField1(int[] field1) {
        this.field1 = field1;
    }

    public Apple(int[] field1) {
        this.field1 = field1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Apple apple = (Apple) super.clone();
        return apple;
    }
}
