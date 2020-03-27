package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LetterTilePossibilitiesTest {

    @Test
    public void numTilePossibilities() {
        LetterTilePossibilities letterTilePossibilities = new LetterTilePossibilities();
        int possibilities = letterTilePossibilities.numTilePossibilities("AAAB");
        Assert.assertEquals(13,possibilities);
    }
}