package com.example.demo.designpatterns.creational.prototype;

import java.util.Arrays;

/*
    Implementation of prototype pattern using copy constructor
    Apple class must implement Cloneable interface, otherwise Object.clone throws CloneNotSupportedException
 */
public class Lemon {

    private final int[] field1;

    public int[] getField1() {
        return field1;
    }

    //private copy constructor
    private Lemon(Lemon lemon) {
        this.field1 = Arrays.copyOf(lemon.field1, lemon.field1.length);
    }

    public Lemon(int[] field1) {
        this.field1 = field1;
    }

    public Lemon copy() {
        return new Lemon(this);
    }
}
