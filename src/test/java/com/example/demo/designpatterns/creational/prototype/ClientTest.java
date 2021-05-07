package com.example.demo.designpatterns.creational.prototype;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @SneakyThrows
    @Test
    void cloneableShallowCopy() {
        int[] arr = {4,5,6};

        Apple apple = new Apple(arr);
        Apple shallowCopy = (Apple) apple.clone();

        assertTrue(apple.getField1() == shallowCopy.getField1());

        shallowCopy.getField1()[0] = 0;
        assertEquals(0, shallowCopy.getField1()[0]);
        assertEquals(0, apple.getField1()[0]);
    }

    @SneakyThrows
    @Test
    void cloneableDeepCopy() {
        int[] arr = {4,5,6};

        Orange orange = new Orange(arr);
        Orange deepCopy = (Orange) orange.clone();

        assertFalse(orange.getField1() == deepCopy.getField1());

        deepCopy.getField1()[0] = 0;
        assertEquals(0, deepCopy.getField1()[0]);
        assertEquals(4, orange.getField1()[0]);
    }

    @SneakyThrows
    @Test
    void copyConstructorPrototype() {
        int[] arr = {4,5,6};

        Lemon lemon = new Lemon(arr);
        Lemon deepCopy = lemon.copy();

        assertFalse(lemon.getField1() == deepCopy.getField1());

        deepCopy.getField1()[0] = 0;
        assertEquals(0, deepCopy.getField1()[0]);
        assertEquals(4, lemon.getField1()[0]);
    }
}
