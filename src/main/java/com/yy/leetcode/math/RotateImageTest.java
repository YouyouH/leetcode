package com.yy.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateImageTest {
    RotateImage rotateImage = new RotateImage();

    @Test
    public void rotate() {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotateImage.rotate(matrix);

        Assert.assertArrayEquals(
                new int[][]{
                        {13,9,5,1},
                        {14,10,6,2},
                        {15,11,7,3},
                        {16,12,8,4}
                },matrix);
    }

    @Test
    public void rotate2() {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateImage.rotate(matrix);

        Assert.assertArrayEquals(
                new int[][]{
                        {7,4,1},
                        {8,5,2},
                        {9,6,3}
                },matrix
        );
    }

    @Test
    public void rotate3() {
        int[][] matrix = new int[][]{
                {11,12,13,14,15,16},
                {17,18,19,20,21,22},
                {23,24,25,26,27,28},
                {29,30,31,32,33,34},
                {35,36,37,38,39,40},
                {41,42,43,44,45,46}

        };
        rotateImage.rotate(matrix);

        Assert.assertArrayEquals(
                new int[][]{
                        {41,35,29,23,17,11},
                        {42,36,30,24,18,12},
                        {43,37,31,25,19,13},
                        {44,38,32,26,20,14},
                        {45,39,33,27,21,15},
                        {46,40,34,28,22,16}

                },matrix
        );
    }
}