package com.example.demo.designpatterns.structural.decorator;

import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    void decoratorTest() {
        Coffee coffee = new SimpleCoffee();

        //dynamically adding new behaviour
        coffee = new CoffeeMilkDecorator(coffee);
        coffee = new CoffeeSugarDecorator(coffee);
        coffee = new CoffeeFreeCinnamonDecorator(coffee);

        System.out.println("final cost: " + coffee.getCost());
        System.out.println("final ingredients: " + coffee.getIngredients());
    }
}
