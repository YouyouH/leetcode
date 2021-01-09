package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumRootToLeafNumbersTest {
    SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();

    @Test
    public void sumNumbers() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Assert.assertEquals(25, sumRootToLeafNumbers.sumNumbers(root));
    }

    @Test
    public void sumNumbers2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        Assert.assertEquals(12, sumRootToLeafNumbers.sumNumbers(root));
    }

    @Test
    public void sumNumbers3() {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        Assert.assertEquals(1026, sumRootToLeafNumbers.sumNumbers(root));
    }
}