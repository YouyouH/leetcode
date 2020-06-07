package com.yy.leetcode.jianzhioffer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class erchasousuoshudehouxubianliTest {
    erchasousuoshudehouxubianli erchasousuoshudehouxubianli = new erchasousuoshudehouxubianli();

    @Test
    public void verifyPostorder() {
        Assert.assertTrue(erchasousuoshudehouxubianli.verifyPostorder(new int[]{1}));
        Assert.assertTrue(erchasousuoshudehouxubianli.verifyPostorder(new int[]{1,2}));
        Assert.assertTrue(erchasousuoshudehouxubianli.verifyPostorder(new int[]{3,1}));
        Assert.assertTrue(erchasousuoshudehouxubianli.verifyPostorder(new int[]{1,3,2}));
        Assert.assertTrue(erchasousuoshudehouxubianli.verifyPostorder(new int[]{1,2,3}));
    }

    @Test
    public void verifyPostorder1() {
        Assert.assertTrue(erchasousuoshudehouxubianli.verifyPostorder(new int[]{1,3,2,6,5}));
        Assert.assertFalse(erchasousuoshudehouxubianli.verifyPostorder(new int[]{1,6,3,2,5}));
        Assert.assertTrue(erchasousuoshudehouxubianli.verifyPostorder(new int[]{1,3,9,8,5,16,18,17,15,10}));
        Assert.assertFalse(erchasousuoshudehouxubianli.verifyPostorder(new int[]{1,3,9,8,5,16,18,17,10,15}));
    }

    @Test
    public void verifyPostorder2() {
        Assert.assertTrue(erchasousuoshudehouxubianli.verifyPostorder(new int[]{1,2,3,4,5}));
    }
}