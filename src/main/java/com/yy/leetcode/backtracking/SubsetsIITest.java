package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubsetsIITest {

    @Test
    public void subsetsWithDup() {
        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> lists = subsetsII.subsetsWithDup(new int[]{1, 1, 2, 2});
        Assert.assertEquals(9,lists.size());

    }
}