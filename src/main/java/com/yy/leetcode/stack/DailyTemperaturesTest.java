package com.yy.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DailyTemperaturesTest {

    DailyTemperatures dailyTemperatures = new DailyTemperatures();

    @Test
    public void dailyTemperatures() {
        int[] temperatures = dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        Assert.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0},temperatures);
    }
}