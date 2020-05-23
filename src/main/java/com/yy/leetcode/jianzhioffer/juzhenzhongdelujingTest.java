package com.yy.leetcode.jianzhioffer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class juzhenzhongdelujingTest {
    juzhenzhongdelujing juzhenzhongdelujing = new juzhenzhongdelujing();
    @Test
    public void exist() {
        Assert.assertTrue(juzhenzhongdelujing.exist(new char[][]{
                {'a','b','c','e'},
                {'b','e','c','s'},
                {'e','d','e','e'},
                {'a','e','e','m'},
                {'a','d','e','m'}
        },"deeem"));
    }

    @Test
    public void exist2() {
        Assert.assertTrue(juzhenzhongdelujing.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        },"ABCESEEEFS"));
    }
}