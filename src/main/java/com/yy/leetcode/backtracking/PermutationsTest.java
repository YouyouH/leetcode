package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PermutationsTest {

    @Test
    public void permute() {
        Permutations permutations = new Permutations();
        List<List<Integer>> lists = permutations.permute(new int[]{1, 2, 3});
        Assert.assertEquals(6,lists.size());
    }
}