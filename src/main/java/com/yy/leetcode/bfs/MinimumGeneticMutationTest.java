package com.yy.leetcode.bfs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumGeneticMutationTest {

    MinimumGeneticMutation mutation = new MinimumGeneticMutation();

    @Test
    public void minMutation() {
        int steps = mutation.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
        Assert.assertEquals(1,steps);
    }

    @Test
    public void minMutation1() {
        int steps = mutation.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"});
        Assert.assertEquals(3,steps);
    }

    @Test
    public void minMutation2() {
        int steps = mutation.minMutation("AAAAACCC", "AACCCCCC", new String[]{"GAAACCCC","GGACCCCC","AACCCCCC"});
        Assert.assertEquals(-1,steps);
    }
}