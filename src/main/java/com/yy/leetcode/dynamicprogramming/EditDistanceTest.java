package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {
    EditDistance editDistance = new EditDistance();

    @Test
    public void minDistance0() {
        Assert.assertEquals(0,editDistance.minDistance("", ""));
        Assert.assertEquals(2,editDistance.minDistance("", "wo"));
        Assert.assertEquals(2,editDistance.minDistance(" ", "wo"));
    }

    @Test
    public void minDistance() {
        int steps = editDistance.minDistance("horse", "ros");
        Assert.assertEquals(3,steps);
    }

    @Test
    public void minDistance1() {
        int steps = editDistance.minDistance("ab", "a");
        Assert.assertEquals(1,steps);
    }

    /**
     * "dinitrophenylhydrazine"
     * "acetylphenylhydrazine"
     */
    @Test
    public void minDistance2() {
        int steps = editDistance.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine");
        Assert.assertEquals(5,steps);
    }
}