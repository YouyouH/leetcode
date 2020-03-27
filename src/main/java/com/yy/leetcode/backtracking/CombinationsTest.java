package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CombinationsTest {

    @Test
    public void combine() {
        Combinations combinations = new Combinations();
        List<List<Integer>> results = combinations.combine(4, 2);
        Assert.assertEquals(6,results.size());
    }
}