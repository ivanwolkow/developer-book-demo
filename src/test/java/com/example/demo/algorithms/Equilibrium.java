package com.example.demo.algorithms;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Given an array A of N non-negative numbers. Find the element where equilibrium first occurs in the array.
 * Equilibrium element in an array is an element such that the sum of elements on the left it is equal
 * to the sum of elements on the right. Write a function that takes an array A as an argument and returns
 * the index of the first equilibrium element. If no equilibrium element exist, returns -1.
 */
public class Equilibrium {
    @ParameterizedTest
    @MethodSource("equilibrium")
    void equilibrium(int[] values, int expectedResult) {
        Assertions.assertEquals(expectedResult, equilibrium(values));
    }

    private int equilibrium(int[] values) {
        if (values.length < 3) return -1;

        int sum = 0;
        for (int i = 1; i < values.length; i++) {
            sum += values[i];
        }

        int sumLeft = 0;
        int sumRight = sum;

        for (int i = 1; i < values.length; i++) {
            sumLeft += values[i - 1];
            sumRight -= values[i];
            if (sumLeft == sumRight) return i;
            if (sumLeft > sumRight) return -1;
        }

        return -1;
    }

    private static Stream<Arguments> equilibrium() {
        return Stream.of(
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{1}, -1),
                Arguments.of(new int[]{1, 1}, -1),
                Arguments.of(new int[]{1, 1, 1}, 1),
                Arguments.of(new int[]{1, 1, 1, 2}, 2),
                Arguments.of(new int[]{1, 1, 1, 2, 1}, -1)
        );
    }

}
