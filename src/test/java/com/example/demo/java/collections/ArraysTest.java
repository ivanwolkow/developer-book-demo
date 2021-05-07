package com.example.demo.java.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArraysTest {

    @Test
    void arrayAsHashMapKeyTest() {
        HashMap<Object, Object> objects = new HashMap<>();

        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 2, 3};

        System.out.println("'a' hashcode: " + a.hashCode());
        System.out.println("'b' hashcode: " + b.hashCode());
        System.out.println("a.equals(b) = " + a.equals(b));

        objects.put(a, new Object());
        assertTrue(objects.containsKey(a));
        assertFalse(objects.containsKey(b));

        a[2] = 4;
        System.out.println("'a' hashcode after modifying: " + a.hashCode());
    }

    @Test
    void arraysUtilsTest() {
        int[] arr = {1, 2, 3};
        List<Integer> list = Arrays.asList(1, 2, 3);
        int[] copy = Arrays.copyOf(arr, arr.length);
        //Compares two int arrays lexicographically:
        int compareResult = Arrays.compare(arr, new int[]{1, 2, 3});
        boolean equals = Arrays.equals(arr, new int[]{1, 2, 3});
        Arrays.fill(arr, 0);
        int searchResult = Arrays.binarySearch(arr, 2);
        Arrays.sort(arr);
        int hashCode = Arrays.hashCode(arr);
        IntStream stream = Arrays.stream(arr);
    }
}
