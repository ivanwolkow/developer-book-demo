package com.example.demo.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortByParity {

    @ParameterizedTest
    @MethodSource("sortArrayByParity")
    void testSortByParity(int[] input, int[] expected) {
        assertArrayEquals(expected, sortArrayByParity(input));
    }

    public int[] sortArrayByParity(int[] nums) {
        int a = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) continue;

            int tmp = nums[a];
            nums[a++] = nums[i];
            nums[i] = tmp;
        }

        return nums;
    }

    private static Stream<Arguments> sortArrayByParity() {
        return Stream.of(
                Arguments.of(
                        new int[]{3, 1, 2, 4},
                        new int[]{2, 4, 3, 1}
                ),
                Arguments.of(
                        new int[]{},
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{2, 2},
                        new int[]{2, 2}
                ),
                Arguments.of(
                        new int[]{3},
                        new int[]{3}
                ),
                Arguments.of(
                        new int[]{3, 5, 7},
                        new int[]{3, 5, 7}
                )
        );
    }
}
