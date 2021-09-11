package com.yy.leetcode.binarySearch;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class erweishuzudechazhaoTest {

    @Test
    public void findNumberIn2DArray() {
        int[][] array = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        Assert.assertTrue(new erweishuzudechazhao().findNumberIn2DArray(array, 5));
        Assert.assertFalse(new erweishuzudechazhao().findNumberIn2DArray(array, 20));

    }
}