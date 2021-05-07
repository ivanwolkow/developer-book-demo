package com.example.demo.designpatterns.structural.decorator;

public class CoffeeFreeCinnamonDecorator extends CoffeeDecorator{

    public CoffeeFreeCinnamonDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + "+cinnamon";
    }
}
