package com.yy.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class PascalsTriangleTest {
    PascalsTriangle pascalsTriangle = new PascalsTriangle();
    @Test
    public void generate() {
        pascalsTriangle.generate(5);
    }
}