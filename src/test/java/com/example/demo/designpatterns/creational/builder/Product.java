package com.example.demo.designpatterns.creational.builder;

public class Product {

    private int field1;
    private String field2;
    private long field3;

    private Product() {
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
        return new Product().new ProductBuilder();
    }


    public class ProductBuilder {

        private ProductBuilder() {
        }

        public ProductBuilder field1(int field1) {
            Product.this.field1 = field1;
            return this;
        }

        public ProductBuilder field2(String field2) {
            Product.this.field2 = field2;
            return this;
        }

        public ProductBuilder field3(long field3) {
            Product.this.field3 = field3;
            return this;
        }

        public Product build() {
            return Product.this;
        }
    }

}
