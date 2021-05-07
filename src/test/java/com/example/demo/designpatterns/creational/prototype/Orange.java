package com.example.demo.designpatterns.creational.prototype;

import java.util.Arrays;

/*
    Implementation of prototype pattern (deep copy)
    Orange class must implement Cloneable interface, otherwise Object.clone throws CloneNotSupportedException
 */
public class Orange implements Cloneable {

    private int[] field1;

    public Orange(int[] field1) {
        this.field1 = field1;
    }

    public int[] getField1() {
        return field1;
    }

    public void setField1(int[] field1) {
        this.field1 = field1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Orange clone = (Orange) super.clone();
        clone.field1 = Arrays.copyOf(field1, field1.length);
        return clone;
    }
}
