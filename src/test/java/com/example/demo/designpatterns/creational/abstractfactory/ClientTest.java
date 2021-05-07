package com.example.demo.designpatterns.creational.abstractfactory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
    Code below is an example of how to implement and use abstract factory pattern
 */
public class ClientTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void abstractFactoryTest(int factory) {
        AbstractFactory abstractFactory;

        if (factory == 1) {
            abstractFactory = new ConcreteFactory1();
        } else {
            abstractFactory = new ConcreteFactory2();
        }

        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();
    }

}
