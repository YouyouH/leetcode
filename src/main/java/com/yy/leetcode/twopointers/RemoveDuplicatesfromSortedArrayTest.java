package com.yy.leetcode.twopointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesfromSortedArrayTest {

    @Test
    public void removeDuplicates() {
        RemoveDuplicatesfromSortedArray sortedArray = new RemoveDuplicatesfromSortedArray();
        int duplicates = sortedArray.removeDuplicates(new int[]{1,1,2});
        Assert.assertEquals(2,duplicates);
    }

    @Test
    public void removeDuplicates1() {
        RemoveDuplicatesfromSortedArray sortedArray = new RemoveDuplicatesfromSortedArray();
        int duplicates = sortedArray.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        Assert.assertEquals(5,duplicates);
    }
}