package com.example.demo.designpatterns.creational.singleton;

public class SingletonEarlyInitialization {

    private static final SingletonEarlyInitialization s = new SingletonEarlyInitialization();

    private SingletonEarlyInitialization(){ }

    public static SingletonEarlyInitialization getInstance(){
        return s;
    }
}
