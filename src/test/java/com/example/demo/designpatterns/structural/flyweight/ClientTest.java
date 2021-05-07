package com.example.demo.designpatterns.structural.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ClientTest {

    @Test
    void flyweightTest() {
        ObjectFactory objectFactory = new ObjectFactory();

        FlyweightObject instance1 = objectFactory.createFlyweightObject("KEY1", 1);
        FlyweightObject instance2 = objectFactory.createFlyweightObject("KEY2", 2);
        FlyweightObject instance3 = objectFactory.createFlyweightObject("KEY1", 3);

        assertNotSame(instance1.getIntrinsicState(), instance2.getIntrinsicState());
        assertSame(instance1.getIntrinsicState(), instance3.getIntrinsicState());
    }
}
