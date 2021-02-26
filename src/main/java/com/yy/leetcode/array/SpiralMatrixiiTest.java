package com.yy.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralMatrixiiTest {

    SpiralMatrixii spiralMatrixii = new SpiralMatrixii();

    @Test
    public void generateMatrix() {
        Assert.assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, spiralMatrixii.generateMatrix(3));
        Assert.assertArrayEquals(new int[][]{{1}}, spiralMatrixii.generateMatrix(1));
    }
}