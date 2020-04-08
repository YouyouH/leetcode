package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumPathSumTest {

    MinimumPathSum minimumPathSum = new MinimumPathSum();

    @Test
    public void minPathSum() {
        int pathSum = minimumPathSum.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        });
        Assert.assertEquals(7,pathSum);
    }
}