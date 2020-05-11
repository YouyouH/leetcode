package com.yy.leetcode.jianzhioffer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class 礼物最大值Test {
    礼物最大值 liwu = new 礼物最大值();

    @Test
    public void maxValue() {
        Assert.assertEquals(9,liwu.maxValue(new int[][]{
                {1, 2, 5},
                {3, 2, 1}
        }));
    }
}