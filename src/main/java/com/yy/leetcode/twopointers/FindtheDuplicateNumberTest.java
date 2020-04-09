package com.yy.leetcode.twopointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindtheDuplicateNumberTest {
    FindtheDuplicateNumber findtheDuplicateNumber = new FindtheDuplicateNumber();
    @Test
    public void findDuplicate() {
        Assert.assertEquals(3,findtheDuplicateNumber.findDuplicate(new int[]{3,1,3,4,2}));
        Assert.assertEquals(3,findtheDuplicateNumber.findDuplicate(new int[]{1,3,1,3,4,2}));
    }
}