package com.yy.leetcode.bfs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumHeightTreesTest {
    MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
    @Test
    public void findMinHeightTrees() {
        Assert.assertArrayEquals(new Integer[]{1}, minimumHeightTrees.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}).toArray(new Integer[0]));
    }
}