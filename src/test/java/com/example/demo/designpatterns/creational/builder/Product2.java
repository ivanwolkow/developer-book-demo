package com.example.demo.designpatterns.creational.builder;

/*
    This is a classic builder implementation (immutable)
 */
public class Product2 {
    private final int field1;
    private final String field2;
    private final long field3;

    private Product2(int field1, String field2, long field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public int getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public long getField3() {
        return field3;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private int field1;
        private String field2;
        private long field3;

        private ProductBuilder() {
        }

        public ProductBuilder field1(int field1) {
            this.field1 = field1;
            return this;
        }

        public ProductBuilder field2(String field2) {
            this.field2 = field2;
            return this;
        }

        public ProductBuilder field3(long field3) {
            this.field3 = field3;
            return this;
        }

        public Product2 build() {
            //do some checks if necessary
            return new Product2(field1, field2, field3);
        }
    }
}
