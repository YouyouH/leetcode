package com.yy.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CombinationSumIIITest {
    CombinationSumIII combinationSumIII = new CombinationSumIII();

    @Test
    public void combinationSum31() {
        Assert.assertEquals(combinationSumIII.combinationSum3(0, 0).size(), 0);
        Assert.assertEquals(combinationSumIII.combinationSum3(3, 7).size(), 1);
        Assert.assertEquals(combinationSumIII.combinationSum3(1, 1).size(), 1);
        Assert.assertEquals(combinationSumIII.combinationSum3(1, 2).size(), 1);
    }

    @Test
    public void combinationSum32() {
        Assert.assertEquals(combinationSumIII.combinationSum3(3, 9).size(), 3);
    }
}