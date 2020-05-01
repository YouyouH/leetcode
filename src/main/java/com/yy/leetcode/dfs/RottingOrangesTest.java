package com.yy.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RottingOrangesTest {
    RottingOranges rottingOranges = new RottingOranges();

    @Test
    public void orangesRotting() {
        Assert.assertEquals(4,rottingOranges.orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }));
    }

    @Test
    public void orangesRotting1() {
        Assert.assertEquals(-1,rottingOranges.orangesRotting(new int[][]{
                {0,1},
        }));
    }

    @Test
    public void orangesRotting2() {
        Assert.assertEquals(1,rottingOranges.orangesRotting(new int[][]{
                {1,2},
        }));
    }

    @Test
    public void orangesRotting3() {
        Assert.assertEquals(0,rottingOranges.orangesRotting(new int[][]{
                {0},
        }));
    }
}