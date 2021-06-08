package com.example.demo.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Iterative approach to convert from any base to decimal
    BCDE = E + D*26 + C*26*26 + B*26*26*26 = E + 26*(D + 26*(C + 26*(B)) )
    Every iteration the result is multiplied by a base (which is 26 in the example) and added to a following digit
 */
public class NumberSystemConversion {


    public int titleToNumber(String columnTitle) {
        int res = 0;

        for (char c : columnTitle.toCharArray()) {
            res = res * 26 + c - 'A' + 1;
        }

        return res;
    }

    @Test
    void test() {
        assertEquals(1, titleToNumber("A"));
        assertEquals(28, titleToNumber("AB"));
        assertEquals(701, titleToNumber("ZY"));
        assertEquals(2147483647, titleToNumber("FXSHRXW"));
    }
}
