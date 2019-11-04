package com.yy.leetcode;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LetterCombinationsofaPhoneNumberTest {

    @Test
    public void letterCombinations() {
        LetterCombinationsofaPhoneNumber letterCombinationsofaPhoneNumber = new LetterCombinationsofaPhoneNumber();
        Assert.assertEquals(9,letterCombinationsofaPhoneNumber.letterCombinations("23").size());
        Assert.assertEquals(27,letterCombinationsofaPhoneNumber.letterCombinations("234").size());
        Assert.assertEquals(0,letterCombinationsofaPhoneNumber.letterCombinations("").size());
    }

    @Test
    public void letterCombinations2() {
        LetterCombinationsofaPhoneNumber letterCombinationsofaPhoneNumber = new LetterCombinationsofaPhoneNumber();
        Assert.assertTrue(0 == letterCombinationsofaPhoneNumber.letterCombinations(" ").size());
        Assert.assertTrue(0 == letterCombinationsofaPhoneNumber.letterCombinations("").size());
        Assert.assertTrue(0 == letterCombinationsofaPhoneNumber.letterCombinations(" 2").size());
        Assert.assertTrue(0 == letterCombinationsofaPhoneNumber.letterCombinations("2 2").size());
        Assert.assertTrue(0 == letterCombinationsofaPhoneNumber.letterCombinations("2 ").size());
    }
}