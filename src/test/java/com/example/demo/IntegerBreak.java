package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Given an integer n, break it into the sum of k positive integers, where k >= 2,
 * and maximize the product of those integers.
 * <p>
 * Return the maximum product you can get.
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;

        int res = (n / 3);
        if (n % 3 == 1) return pow3(res - 1) * 4;
        if (n % 3 == 2) return pow3(res) * 2;
        return pow3(res);
    }

    private int pow3(int pow) {
        if (pow == 0) return 1;
        int x = 3;
        for (int i = 1; i < pow; i++) {
            x *= 3;
        }
        return x;
    }

    @ParameterizedTest
    @MethodSource("integerBreak")
    void canReach(int num, int res) {
        Assertions.assertEquals(res, integerBreak(num));
    }

    private static Stream<Arguments> integerBreak() {
        return Stream.of(
                Arguments.of(2, 1), // 2 - 1,1
                Arguments.of(3, 2), // 3 - 2,1
                Arguments.of(4, 4), // 4 - 2,2
                Arguments.of(5, 6), // 5 - 3,2
                Arguments.of(6, 9), // 6 - 3,3
                Arguments.of(7, 12), // 7 - 3,4
                Arguments.of(8, 18), // 8 - 3,3,2
                Arguments.of(9, 27), // 9 - 3,3,3
                Arguments.of(10, 36), // 10 - 3,3,4
                Arguments.of(11, 54), // 11 - 3,3,3,2
                Arguments.of(12, 81), // 12 - 3,3,3,3
                Arguments.of(13, 108), // 13 - 3,3,3,4
                Arguments.of(14, 162), //14 - 3,3,3,3,2
                Arguments.of(15, 243), //15 - 3,3,3,3,3
                Arguments.of(58, 1549681956));
    }
}
