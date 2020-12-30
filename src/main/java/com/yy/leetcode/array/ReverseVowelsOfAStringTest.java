package com.yy.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseVowelsOfAStringTest {
    ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();
    @Test
    public void reverseVowels() {
        Assert.assertEquals("holle", reverseVowelsOfAString.reverseVowels("hello"));
        Assert.assertEquals("leotcede", reverseVowelsOfAString.reverseVowels("leetcode"));
        Assert.assertEquals(null, reverseVowelsOfAString.reverseVowels(null));
        Assert.assertEquals("", reverseVowelsOfAString.reverseVowels(""));
        Assert.assertEquals(" ", reverseVowelsOfAString.reverseVowels(" "));
        Assert.assertEquals("  ", reverseVowelsOfAString.reverseVowels("  "));
        Assert.assertEquals("  a", reverseVowelsOfAString.reverseVowels("  a"));
    }
}