package com.example.demo.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * i.e. for each nums[i] you need to count the number of valid j's such that j != i and nums[j] < nums[i].
 */
public class SmallerThanTheCurrent {

    @ParameterizedTest
    @MethodSource("testSmallerThanTheCurrent")
    void testSmallerThanTheCurrent(int[] input, int[] expected) {
        Assertions.assertArrayEquals(expected, smallerNumbersThanCurrent(input));
    }

    private static Stream<Arguments> testSmallerThanTheCurrent() {
        return Stream.of(
                Arguments.of(
                        new int[]{8, 1, 2, 2, 3},
                        new int[]{4, 0, 1, 1, 3}
                ),
                Arguments.of(
                        new int[]{6, 5, 4, 8},
                        new int[]{2, 1, 0, 3}
                ),
                Arguments.of(
                        new int[]{7, 7, 7, 7},
                        new int[]{0, 0, 0, 0}
                ),
                Arguments.of(
                        new int[]{1},
                        new int[]{0}
                ),
                Arguments.of(
                        new int[]{},
                        new int[]{}
                )
        );
    }


    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(copy[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            copy[i] = map.get(nums[i]);
        }

        return copy;
    }
}
