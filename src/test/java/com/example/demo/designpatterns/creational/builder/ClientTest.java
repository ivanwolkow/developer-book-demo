package com.example.demo.designpatterns.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ClientTest {
    @Test
    void builderTest() {

        Product.ProductBuilder builder = Product.builder();

        Product product = builder
                .field1(10)
                .field2("TEST")
                .field3(923)
                .build();

        assertEquals(10, product.getField1());
        assertEquals("TEST", product.getField2());
        assertEquals(923, product.getField3());

        //however, this implementation has a drawback:
        //the Product object is mutable through its builder
        builder.field1(11);
        assertNotEquals(10, product.getField1());

    }

    @Test
    void builder2Test() {

        Product2.ProductBuilder builder = Product2.builder();

        Product2 product2 = builder
                .field1(10)
                .field2("TEST")
                .field3(923)
                .build();

        assertEquals(10, product2.getField1());
        assertEquals("TEST", product2.getField2());
        assertEquals(923, product2.getField3());


        builder.field1(11); //this will not mutate the object's state
        assertEquals(10, product2.getField1());
    }

    @Test
    void lombokBuilderTest() {
        Product3.Product3Builder builder = Product3.builder();

        Product3 product3 = builder
                .field1(10)
                .field2("TEST")
                .field3(923)
                .build();

        assertEquals(10, product3.getField1());
        assertEquals("TEST", product3.getField2());
        assertEquals(923, product3.getField3());

        builder.field1(11); //this will not mutate the object's state
        assertEquals(10, product3.getField1());
    }
}
