package com.example.demo.java.oop.inner;

public class OuterClass {
    public int outerPublicField = 44;
    private int outerPrivateField = 10;
    private static String outerPrivateStaticField = "123";

    public OuterClass() {
        System.out.println("Outer class constructor called");
    }

    private void outerPrivateMethod() {
        System.out.println("outerPrivateMethod");

        InnerClass innerClass = new InnerClass();
        System.out.println(innerClass.innerPrivateField);
        System.out.println(innerClass.innerPublicField);
        innerClass.innerPublicMethod();
        innerClass.innerProtectedMethod();
        innerClass.innerDefaultMethod();
        innerClass.innerPrivateMethod();

        StaticNestedClass staticNestedClass = new StaticNestedClass();
        System.out.println(staticNestedClass.staticNestedPrivateField);
        System.out.println(StaticNestedClass.staticNestedPrivateStaticField);
        staticNestedClass.staticNestedPrivateMethod();
        staticNestedClass.staticNestedPublicMethod();
    }

    public class InnerClass {
        private int innerPrivateField = 10;
        public int innerPublicField = 11;

        //static declarations in inner classes are not supported
        //private static void innerStaticMethod() {}

        public InnerClass() {
            System.out.println("Inner class constructor called");
        }

        //inner classes have access to other members of the enclosing class, even if they are declared private
        public void innerPublicMethod() {
            System.out.println(outerPrivateField);
            outerPrivateMethod();
            System.out.println(outerPublicField);
        }

        void innerDefaultMethod() {}
        private void innerPrivateMethod() {}
        private void innerProtectedMethod() {}
    }

    public static class StaticNestedClass {
        private static int staticNestedPrivateStaticField = 44;
        private int staticNestedPrivateField = 55;

        public StaticNestedClass() {
            System.out.println("Static nested class constructor called");
        }

        public void staticNestedPublicMethod() {
            System.out.println(outerPrivateStaticField);

            //Static nested classes DO NOT have access to other members of the enclosing class:
            //System.out.println(outerPrivateField);
            //System.out.println(outerPublicField);
        }
        private void staticNestedPrivateMethod() {

        }

        public static void staticNestedPublicStaticMethod() {
            System.out.println(outerPrivateStaticField);
        }
    }
}
