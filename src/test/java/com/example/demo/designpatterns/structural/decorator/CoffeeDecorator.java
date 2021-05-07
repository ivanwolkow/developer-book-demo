package com.example.demo.designpatterns.structural.decorator;

public abstract class CoffeeDecorator implements Coffee {

    private Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return this.coffee.getCost();
    }

    @Override
    public String getIngredients() {
        return this.coffee.getIngredients();
    }
}
