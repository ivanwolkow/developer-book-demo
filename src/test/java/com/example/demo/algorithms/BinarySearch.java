package com.example.demo.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch {

    @ParameterizedTest
    @MethodSource("testBinarySearch")
    void testBinarySearch(int[] input, int value, int expectedResult) {
        assertEquals(expectedResult, binarySearch(input, 0, input.length - 1, value));
    }

    public int binarySearch(int[] nums, int start, int end, int value) {
        if (start > end) return -1;
        if (nums[start] > value || nums[end] < value) return -1;

        if (start == end) {
            if (nums[start] == value) return start;
            else return -1;
        }

        int mid = (1 + end - start) / 2;

        int leftResult = binarySearch(nums, start, start + mid - 1, value);
        if (leftResult != -1) return leftResult;

        return binarySearch(nums, start + mid, end, value);
    }

    private static Stream<Arguments> testBinarySearch() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 5, 6, 7, 12, 44, 122, 200, 300, 400, 1000},
                        5,
                        2
                ),
                Arguments.of(
                        new int[]{1, 2, 5, 6, 7, 12, 44, 122, 200, 300, 400, 1000},
                        44,
                        6
                ),
                Arguments.of(
                        new int[]{1},
                        2,
                        -1
                ),
                Arguments.of(
                        new int[]{},
                        2,
                        -1
                ),
                Arguments.of(
                        new int[]{1, 2},
                        1,
                        0
                ),
                Arguments.of(
                        new int[]{1, 2},
                        2,
                        1
                )
        );
    }

}
