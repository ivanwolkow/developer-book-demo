package com.example.demo.designpatterns.creational.singleton;

public class SingletonDoubleCheckedLocking {

    //the field needs to be volatile to prevent cache incoherence issues.
    //In fact, the Java memory model allows the publication of
    //partially initialized objects and this may lead in turn to subtle bugs.
    private static volatile SingletonDoubleCheckedLocking s;

    private SingletonDoubleCheckedLocking() {
    }

    //double check is a performance optimization.
    //without it we'd need to acquire a potentially unnecessary lock
    //each time we want to get the instance of our singleton
    public static SingletonDoubleCheckedLocking getInstance() {
        if (s == null) {
            synchronized (SingletonDoubleCheckedLocking.class) {
                if (s == null) {
                    s = new SingletonDoubleCheckedLocking();
                }
            }
        }

        return s;
    }
}
