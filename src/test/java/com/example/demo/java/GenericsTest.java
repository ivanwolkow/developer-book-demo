package com.example.demo.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

    @Test
    void simpleGenericMethod() {

        printAll(new String[]{"a", "b", "c", "d"});
        printAll(new Integer[]{1, 2, 3, 4});
        printAll(new Object[]{new Object() {
            @Override
            public String toString() {
                return "custom object";
            }
        }});
    }

    public <X> void printAll(X[] elements) {
        for (X el : elements) {
            System.out.printf("%s", el);
        }
        System.out.println();
    }


    @Test
    void boundedMethodType() {
        Integer result = maximum(10, 15);
        Assertions.assertEquals(15, result);
    }

    public <X extends Comparable<X>> X maximum(X x, X y) {
        if (x.compareTo(y) > 0) return x;
        else return y;
    }

    @Test
    void genericsClassTest() {
        Container<String> source = new Container<>("source");
        String t = source.getT();
    }

    class Container<T> {
        private T t;

        public Container(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }
    }

    @Test
    void boundedTypeParameter() {
        List<String> a = List.of("a", "b", "c");
        String max = boundedTypeParameter(a);
    }


    public <T extends Comparable<T>> T boundedTypeParameter(List<T> c) {
        T max = c.get(0);   //we have a type information

        for (T t : c) {
            if (t.compareTo(max) > 0) max = t;
        }

        return max;
    }

    @Test
    void listContains() {
        //ok, we do not require types to be the same
        listContains(List.of("a", "b"), 3);

        List<? extends Comparable> a = List.of("a", "b", 3);
        List<? extends Serializable> b = List.of("a", "b", 3);
        //List<? extends CharSequence> c = List.of("a", "b", 3);
        List<? extends CharSequence> d = List.of("a", "b", "asd");

        //we used single T type for both arguments but it is still possible to do something like this:
        listContains2(List.of("a", "b", 3), 3);
        //List.of("a", "b", 3) -> List<Serializable & Comparable> - common ancestors for String and Integer
    }

    public static <T> void listContains(List<?> myList, T obj) {
        if (myList.contains(obj)) {
            System.out.println("The list contains the element: " + obj);
        } else {
            System.out.println("The list does not contain the element: " + obj);
        }
    }

    public static <T> void listContains2(List<T> myList, T obj) {
        if (myList.contains(obj)) {
            System.out.println("The list contains the element: " + obj);
        } else {
            System.out.println("The list does not contain the element: " + obj);
        }
    }

    @Test
    void copyTest() {
        ArrayList<Number> numbers = new ArrayList<>(20);
        ArrayList<Integer> integers = new ArrayList<>(20);

        copy(integers, numbers);

    }

    public static <T> void copy(List<? extends T> src, List<? super T> dst) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    @Test
    void pecsExperiments() {
        ArrayList<? extends CharSequence> cs = new ArrayList<>();
        //this works as any subclass of CharSequence can be safely upcasted to CharSequence (type producing)
        CharSequence charSequence = cs.get(0);
        //below line won't compile, as 'cs' may be of any type other than String (type consuming)
        //cs.add("string");

        ArrayList<? super String> strs = new ArrayList<>();
        //this works as String can be safely upcasted to any type Object..String (type consuming)
        strs.add("234");
        //Object type available here (without explicit casting) because this list can be of any type in between Object..String
        Object s = strs.get(0);
    }
}
