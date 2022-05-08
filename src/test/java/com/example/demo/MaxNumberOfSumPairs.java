package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 */
public class MaxNumberOfSumPairs {


    @ParameterizedTest
    @MethodSource("maxNumberOfSumPairs")
    void maxNumberOfSumPairs(int[] nums, int number, int expectedResult) {
        assertEquals(expectedResult, maxOperations(nums, number));
    }

    private static Stream<Arguments> maxNumberOfSumPairs() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2},
                        3,
                        4
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1},
                        3,
                        2
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        5,
                        2
                ),
                Arguments.of(
                        new int[]{3, 1, 3, 4, 3},
                        6,
                        1
                )
        );
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int cnt = 0;
        for (int num : nums) {

            Integer saved = map.get(k - num);
            if (saved != null && saved > 0) {
                cnt++;
                map.put(k - num, saved - 1);
            } else {
                map.compute(num, (a, b) -> b == null ? 1 : b + 1);
            }
        }

        return cnt;
    }

}
