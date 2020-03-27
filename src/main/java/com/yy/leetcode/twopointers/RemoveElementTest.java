package com.yy.leetcode.twopointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveElementTest {

    @Test
    public void removeElement() {
        RemoveElement removeElement = new RemoveElement();
        int[] input = {0, 1, 2, 2, 3, 0, 4, 2};
        int element = removeElement.removeElement(input, 2);
        Assert.assertEquals(element,5);
    }
}