package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationsofaPhoneNumberTest {
    LetterCombinationsofaPhoneNumber combinationsofaPhoneNumber = new LetterCombinationsofaPhoneNumber();

    @Test
    public void letterCombinations() {

        List<String> result = combinationsofaPhoneNumber.letterCombinations("23");
        Assert.assertArrayEquals(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}, result.toArray());
    }

    @Test
    public void letterCombinations1() {

        List<String> result = combinationsofaPhoneNumber.letterCombinations("");
        Assert.assertArrayEquals(new String[]{}, result.toArray());
    }
}