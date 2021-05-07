package com.example.demo.designpatterns.creational.singleton;

public class SingletonNaiveImpl {
    private static SingletonNaiveImpl s;

    private SingletonNaiveImpl(){
    }

    public static SingletonNaiveImpl getInstance() {
        if (s == null) {
            s = new SingletonNaiveImpl();
        }
        return s;
    }
}
