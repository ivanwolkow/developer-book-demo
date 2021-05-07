package com.example.demo.designpatterns.creational.abstractfactory;

public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }

    private static class ConcreteProductA1 implements AbstractProductA {
        public ConcreteProductA1() {
            System.out.println(this.getClass().getName());
        }
    }

    private static class ConcreteProductB1 implements AbstractProductB {
        public ConcreteProductB1() {
            System.out.println(this.getClass().getName());
        }
    }
}
