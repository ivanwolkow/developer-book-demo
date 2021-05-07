package com.example.demo.designpatterns.creational.abstractfactory;

public class ConcreteFactory2 implements AbstractFactory{
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }

    private static class ConcreteProductA2 implements AbstractProductA {
        public ConcreteProductA2() {
            System.out.println(this.getClass().getName());
        }
    }

    private static class ConcreteProductB2 implements AbstractProductB {
        public ConcreteProductB2() {
            System.out.println(this.getClass().getName());
        }
    }

}
