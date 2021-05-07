package com.example.demo.designpatterns.creational.builder;

import lombok.Builder;
import lombok.Getter;

/*
    Code below utilizes a builder implementation provided by lombok
 */
@Getter
@Builder
public class Product3 {
    private final int field1;
    private final String field2;
    private final long field3;
}
