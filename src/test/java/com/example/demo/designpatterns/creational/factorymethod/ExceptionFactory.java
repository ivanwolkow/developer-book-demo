package com.example.demo.designpatterns.creational.factorymethod;

public class ExceptionFactory {

    public BaseException userNotFound() {
        return new UserNotFoundException();
    }

    public BaseException notEnoughMoney() {
        return new NotEnoughMoneyException();
    }

    public BaseException orderNotFoundException() {
        return new OrderNotFoundException();
    }

}
