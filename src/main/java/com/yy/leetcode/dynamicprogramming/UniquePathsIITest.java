package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsIITest {

    UniquePathsII uniquePathsII = new UniquePathsII();

    @Test
    public void uniquePathsWithObstacles() {
        int[][] obstacleGrid = {{0, 1, 0}, {0,0,0},{1,0,0}};
        Assert.assertEquals(2, uniquePathsII.uniquePathsWithObstacles(obstacleGrid));

        int[][] obstacleGrid2 = {{1}};
        Assert.assertEquals(0, uniquePathsII.uniquePathsWithObstacles(obstacleGrid2));

        int[][] obstacleGrid3 = {{0}};
        Assert.assertEquals(1, uniquePathsII.uniquePathsWithObstacles(obstacleGrid3));
    }
}