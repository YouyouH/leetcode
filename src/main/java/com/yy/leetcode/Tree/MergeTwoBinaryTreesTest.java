package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoBinaryTreesTest {

    @Test
    public void mergeTrees() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);

        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);

        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode result = mergeTwoBinaryTrees.mergeTrees(t1, t2);
        Assert.assertEquals(3,result.val);
        Assert.assertEquals(4,result.left.val);
        Assert.assertEquals(5,result.right.val);

        Assert.assertEquals(5,result.left.left.val);
        Assert.assertEquals(4,result.left.right.val);

        Assert.assertEquals(7,result.right.right.val);
    }
}