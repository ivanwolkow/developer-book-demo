package com.example.demo.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfOnes {


    public int numberOfOnes(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) bits++;
            mask <<= 1;
        }
        return bits;
    }

    @Test
    void name() {
        assertEquals(3, numberOfOnes(11));
        assertEquals(1, numberOfOnes(128));
        assertEquals(31, numberOfOnes(-3));
        assertEquals(1, numberOfOnes(-2147483648));
    }
}
