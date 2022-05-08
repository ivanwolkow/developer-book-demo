package com.example.demo.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * You are given a 0-indexed binary string s and two integers minJump and maxJump.
 * In the beginning, you are standing at index 0, which is equal to '0'.
 * You can move from index i to index j if the following conditions are fulfilled:
 * <p>
 * i + minJump <= j <= min(i + maxJump, s.length - 1), and s[j] == '0'.
 * Return true if you can reach index s.length - 1 in s, or false otherwise.
 */
public class JumpGame7 {

    @ParameterizedTest
    @MethodSource("canReach")
    void canReach(String s, int minJump, int maxJump, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, canReach(s, minJump, maxJump));
    }

    private static Stream<Arguments> canReach() {
        return Stream.of(
                Arguments.of("011010", 2, 3, true),
                Arguments.of("01101110", 2, 3, false),
                Arguments.of("01100101110", 3, 4, true),
                Arguments.of("011001011110", 3, 4, false),
                Arguments.of("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                        5, 99998, true),
                Arguments.of("000000000000000", 3, 13, true),
                Arguments.of("01", 1, 1, false)
        );
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') return false;

        int[] ints = new int[s.length()];
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += ints[i];

            if (i > 0) {    //skip checking conditions for the first element
                if (sum <= 0) continue;
                if (s.charAt(i) == '1') continue;
            }

            if (i + minJump > s.length() - 1) continue;
            ints[i + minJump]++;

            if (i + maxJump + 1 > s.length() - 1) continue;
            ints[i + maxJump + 1]--;
        }

        return (sum > 0);
    }
}
