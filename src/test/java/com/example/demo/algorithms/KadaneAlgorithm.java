package com.example.demo.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum, and return its sum
 */
public class KadaneAlgorithm {

    @ParameterizedTest
    @MethodSource("kadaneAlgorithm")
    void name(int[] input, int maxSum) {
        assertEquals(maxSum, kadaneAlgorithm(input));
    }

    private int kadaneAlgorithm(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = maxCurrent;

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) maxGlobal = maxCurrent;
        }

        return maxGlobal;
    }

    private static Stream<Arguments> kadaneAlgorithm() {
        return Stream.of(
                Arguments.of(
                        new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4},
                        6
                ),
                Arguments.of(
                        new int[]{5, 4, -1, 7, 8},
                        23
                ),
                Arguments.of(
                        new int[]{1},
                        1
                )
        );
    }
}
