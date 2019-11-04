package com.yy.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters longestSub = new LongestSubstringWithoutRepeatingCharacters();
        Assert.assertEquals(3, longestSub.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, longestSub.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, longestSub.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(4, longestSub.lengthOfLongestSubstring("abcabcdabc"));
        Assert.assertEquals(4, longestSub.lengthOfLongestSubstring("abcddddd"));
    }
    @Test
    public void lengthOfLongestSubstring2() {
        LongestSubstringWithoutRepeatingCharacters longestSub = new LongestSubstringWithoutRepeatingCharacters();
        Assert.assertEquals(2, longestSub.lengthOfLongestSubstring("aab"));
    }

    @Test
    public void lengthOfLongestSubstring3() {
        LongestSubstringWithoutRepeatingCharacters longestSub = new LongestSubstringWithoutRepeatingCharacters();
        Assert.assertEquals(3, longestSub.lengthOfLongestSubstring("dvdf"));
    }
}