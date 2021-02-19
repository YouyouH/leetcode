package com.yy.leetcode.dynamicprogramming.minimax;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PredictTheWinnerTest {

    PredictTheWinner predictTheWinner = new PredictTheWinner();
    @Test
    public void predictTheWinner() {
        Assert.assertFalse(predictTheWinner.PredictTheWinner(new int[]{1, 5, 2}));
        Assert.assertTrue(predictTheWinner.PredictTheWinner(new int[]{1, 5, 233, 7}));
    }
}