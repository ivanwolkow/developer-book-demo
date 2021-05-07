package com.example.demo.designpatterns.structural.decorator;

public class CoffeeMilkDecorator extends CoffeeDecorator{
    public CoffeeMilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 5;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + "+milk";
    }
}
