package com.yy.leetcode.dynamicprogramming.dp_on_strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {

    EditDistance editDistance = new EditDistance();

    @Test
    public void minDistance() {
        Assert.assertEquals(editDistance.minDistance("",""),0);
        Assert.assertEquals(editDistance.minDistance("",""),0);
        Assert.assertEquals(editDistance.minDistance(""," "),1);
    }
}