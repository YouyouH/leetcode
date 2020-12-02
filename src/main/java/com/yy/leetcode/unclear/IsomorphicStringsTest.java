package com.yy.leetcode.unclear;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsomorphicStringsTest {
    IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
    @Test
    public void isIsomorphic() {
        Assert.assertFalse(isomorphicStrings.isIsomorphic("ab", "aa"));
    }
}