package com.example.demo.java.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OverridingOverloadingTest {

    @Test
    void overloadingTest() {
        BaseClass baseClass = new BaseClass();

        System.out.println(baseClass.method1("1"));
        System.out.println(baseClass.method1((Object) "2"));
        System.out.println(baseClass.method1(new String[] {"3"}));
        System.out.println(baseClass.method1(new Object[] {"4"}));
    }

    public static class BaseClass {
        public String method1(String arg) {
            return "String:" + arg;
        }

        public String method1(String ... args) {
            return "String ... args:" + Arrays.stream(args)
                    .collect(Collectors.joining());
        }

        public String method1(Object arg) {
            return "Object arg:" + arg.toString();
        }

        public String method1(Object ... args) {
            return "Object ... args:" + Arrays.stream(args)
                    .map(Object::toString)
                    .collect(Collectors.joining());
        }
    }

    @Test
    void overridingTest() {
        Parent cls = new Child();
        cls.say();
        System.out.println("Obtaining var externally: " + cls.var);
        System.out.println("Obtaining var externally using overriding: " + cls.getVar());
    }

    public static class Parent {
        public int var = 0;

        public void say() {
            System.out.println("I'm parent, var=" + var);
        }

        public int getVar() {
            return var;
        }
    }

    public static class Child extends Parent {
        public int var = 1;

        public void say() {
            System.out.println("I'm child, var=" + var);
        }

        @Override
        public int getVar() {
            return var; //we could access the parent var using super.var
        }
    }

}
