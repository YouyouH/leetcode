package com.yy.leetcode.unclear;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLastWordTest {

    LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    @Test
    public void lengthOfLastWord() {
        Assert.assertEquals(1, lengthOfLastWord.lengthOfLastWord("a"));
        Assert.assertEquals(2, lengthOfLastWord.lengthOfLastWord("aa"));
        Assert.assertEquals(2, lengthOfLastWord.lengthOfLastWord("aa "));
        Assert.assertEquals(0, lengthOfLastWord.lengthOfLastWord(""));
        Assert.assertEquals(0, lengthOfLastWord.lengthOfLastWord(" "));
        Assert.assertEquals(1, lengthOfLastWord.lengthOfLastWord(" a"));
        Assert.assertEquals(2, lengthOfLastWord.lengthOfLastWord("aa a a aa "));
        Assert.assertEquals(2, lengthOfLastWord.lengthOfLastWord("aa a a aa"));
    }
}