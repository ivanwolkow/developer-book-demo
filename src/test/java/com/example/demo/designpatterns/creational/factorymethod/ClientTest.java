package com.example.demo.designpatterns.creational.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    This client class is not aware of concrete implementations of BaseException
 */
public class ClientTest {

    @Test
     void exceptionsTest() {
        var exceptionFactory = new ExceptionFactory();

        BaseException baseException = exceptionFactory.notEnoughMoney();
        BaseException baseException1 = exceptionFactory.orderNotFoundException();
        BaseException baseException2 = exceptionFactory.userNotFound();

        assertEquals("NotEnoughMoneyException", baseException.getClass().getSimpleName());
        assertEquals("OrderNotFoundException", baseException1.getClass().getSimpleName());
        assertEquals("UserNotFoundException", baseException2.getClass().getSimpleName());
    }
}
