package com.example.demo.java.oop.inner;

import org.junit.jupiter.api.Test;

public class NestedClassTest {

    @Test
    void playingWithNestedClasses() {
        System.out.println("Now we're going to create inner static instance...");
        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
        staticNestedClass.staticNestedPublicMethod();

        System.out.println("Creating outer class instance...");
        OuterClass outerClass = new OuterClass();
        System.out.println(outerClass.outerPublicField);

        //we cannot instantiate from inner class separately
        //OuterClass.InnerClass innerClass1 = new OuterClass.InnerClass();
        //but we can do it this way:
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.innerDefaultMethod();
        innerClass.innerPublicMethod();
        System.out.println(innerClass.innerPublicField);

    }


    //As a member of the OuterClass, a nested class can be declared private, public, protected, or package private



}
