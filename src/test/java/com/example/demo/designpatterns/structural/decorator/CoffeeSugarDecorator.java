package com.example.demo.designpatterns.structural.decorator;

public class CoffeeSugarDecorator extends CoffeeDecorator{
    public CoffeeSugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 2;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + "+sugar";
    }
}
