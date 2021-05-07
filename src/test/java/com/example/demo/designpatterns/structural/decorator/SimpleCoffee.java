package com.example.demo.designpatterns.structural.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getIngredients() {
        return "coffee";
    }
}
