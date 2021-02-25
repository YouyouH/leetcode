package com.yy.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertIntervalTest {

    InsertInterval insertInterval = new InsertInterval();

    @Test
    public void insert() {
        Assert.assertArrayEquals(new int[][]{{1, 5}, {6, 9}}, insertInterval.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));
        Assert.assertArrayEquals(new int[][]{{1,2},{3,10},{12,16}}, insertInterval.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8}));
        Assert.assertArrayEquals(new int[][]{{5,7}}, insertInterval.insert(new int[][]{}, new int[]{5, 7}));
        Assert.assertArrayEquals(new int[][]{{1,5}}, insertInterval.insert(new int[][]{{1,5}}, new int[]{2, 3}));
        Assert.assertArrayEquals(new int[][]{{1,7}}, insertInterval.insert(new int[][]{{1,5}}, new int[]{2, 7}));
    }
}