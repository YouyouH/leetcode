package com.yy.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberofIslandsTest {

    @Test
    public void numIslands() {
        char[][] grid = new char[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };
        NumberofIslands islands = new NumberofIslands();
        int numIslands = islands.numIslands(grid);
        Assert.assertEquals(3,numIslands);
    }
}