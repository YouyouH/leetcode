package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CombinationSumTest {

    CombinationSum combinationSum = new CombinationSum();

    @Test
    public void combinationSum() {
        Assert.assertArrayEquals(new int[][]{},combinationSum.combinationSum(null, 7).stream().map(a->a.toArray()).toArray());
        Assert.assertArrayEquals(new int[][]{},combinationSum.combinationSum(new int[]{}, 7).stream().map(a->a.toArray()).toArray());
    }

    @Test
    public void combinationSum1() {
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 5}, 8);

        Assert.assertArrayEquals(new int[][]{{2,2,2,2},{2,3,3},{3,5}},lists.stream().map(a->a.toArray()).toArray());
    }

    @Test
    public void combinationSum2() {
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);

        Assert.assertArrayEquals(new int[][]{{2,2,3},{7}},lists.stream().map(a->a.toArray()).toArray());
    }
}