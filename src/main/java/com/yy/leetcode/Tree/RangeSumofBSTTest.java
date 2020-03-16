package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangeSumofBSTTest {

    RangeSumofBST bst = new RangeSumofBST();

    @Test
    public void rangeSumBST() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = null;
        root.right.right = new TreeNode(18);

        Assert.assertEquals(32,bst.rangeSumBST(root,7,15));
        Assert.assertEquals(0,bst.rangeSumBST(root,0,0));
    }

    @Test
    public void rangeSumBST1() {
        Assert.assertEquals(0,bst.rangeSumBST(null,0,0));
    }
}