package com.example.demo.designpatterns.creational.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientTest {

    @Test
    void singletonTest() {
        SingletonNaiveImpl naiveInstance = SingletonNaiveImpl.getInstance();
        assertTrue(naiveInstance == SingletonNaiveImpl.getInstance());

        SingletonDoubleCheckedLocking doubleCheckedLocking = SingletonDoubleCheckedLocking.getInstance();
        assertTrue(doubleCheckedLocking == SingletonDoubleCheckedLocking.getInstance());

        SingletonEarlyInitialization earlyInitialization = SingletonEarlyInitialization.getInstance();
        assertTrue(earlyInitialization == SingletonEarlyInitialization.getInstance());

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        assertTrue(enumSingleton == EnumSingleton.INSTANCE);

    }
}
