package com.yy.leetcode.dynamicprogramming.Decision_Making;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MinimumTotalTest {
    MinimumTotal minimumTotal = new MinimumTotal();
    @Test
    public void minimumTotal() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        Assert.assertEquals(11, minimumTotal.minimumTotal(triangle));

    }

    @Test
    public void minimumTotal2() {
        List<List<Integer>> triangle = new ArrayList<>();
        Assert.assertEquals(0, minimumTotal.minimumTotal(triangle));

    }
}