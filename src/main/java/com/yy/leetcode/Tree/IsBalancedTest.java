package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsBalancedTest {
    IsBalanced isBalanced = new IsBalanced();

    //1,2,2,3,null,null,3,4,null,null,4
    @Test
    public void isBalanced() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = null;

        root.right.left = null;
        root.right.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = null;
        root.right.right.left = null;
        root.right.right.right = new TreeNode(4);

        Assert.assertFalse(isBalanced.isBalanced(root));
    }
}