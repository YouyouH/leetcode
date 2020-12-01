package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueBinarySearchTreesTest {
    UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();

    @Test
    public void numTrees() {
        Assert.assertEquals(42, uniqueBinarySearchTrees.numTrees(5));
    }
}