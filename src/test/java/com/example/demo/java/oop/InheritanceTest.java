package com.example.demo.java.oop;

import org.junit.jupiter.api.Test;

public class InheritanceTest {

    @Test
    void multipleDefaultMethodsProblem() {

        Clazz clazz = new Clazz();
        clazz.dom(1);

    }

    public class Clazz implements IFace, IFace2 {

        String stringVar = "class member variable";

        @Override
        public void dom(int a) {
            System.out.println("Clazz stringVar=" + stringVar);
            System.out.println("But we can access interface stringVar=" + IFace.stringVar);
            IFace.super.dom(a);
        }
    }

    public interface IFace {
        //this member var is implicitly final, public and static
        String stringVar = "interface constant";

        default void dom(int a) {
            System.out.println("Iface: " + a);
        }
    }

    public interface IFace2 {
        default void dom(int a) {
            System.out.println("Iface2: " + a);
        }
    }


}
