package com.yy.leetcode.dynamicprogramming;

import com.yy.leetcode.dynamicprogramming.MaximalSquare;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximalSquareTest {

    MaximalSquare maximalSquare = new MaximalSquare();
    @Test
    public void maximalSquare() {
        int area = maximalSquare.maximalSquare(new char[][]{
                {'1', '0'},
                {'1', '1'},
                {'1', '1'},
                {'1', '0'}
        });
    }
    @Test
    public void maximalSquare1() {
        int area = maximalSquare.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
    }
}