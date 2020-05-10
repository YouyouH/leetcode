package com.yy.leetcode.unclear;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarPoolingTest {
    CarPooling carPooling = new CarPooling();

    @Test
    public void carPooling() {
        carPooling.carPooling(new int[][]{
                {1, 1, 4},
                {9, 4, 9},
                {9, 1, 9},
                {2, 3, 5},
                {4, 1, 5},
                {10, 4, 5}
        }, 33);
    }
}