package com.yy.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PacificAtlanticWaterFlowTest {
    PacificAtlanticWaterFlow flow = new PacificAtlanticWaterFlow();

    @Test
    public void pacificAtlantic() {
        int[][] input = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> results = flow.pacificAtlantic(input);
        Assert.assertEquals(7, results.stream().count());
    }

    @Test
    public void pacificAtlantic1() {
        int[][] input = new int[][]{
                {1}
        };
        List<List<Integer>> results = flow.pacificAtlantic(input);
        Assert.assertEquals(1, results.stream().count());
    }
}