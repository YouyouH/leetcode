package com.yy.leetcode.bfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WordLadderTest {

    WordLadder wordLadder = new WordLadder();

    @Test
    public void ladderLength() {
        int steps = wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Assert.assertEquals(5,steps);
    }
}