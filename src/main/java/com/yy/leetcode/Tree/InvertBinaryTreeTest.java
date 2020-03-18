package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvertBinaryTreeTest {

    InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

    @Test
    public void invertTree() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = null;
        root.right.right = new TreeNode(18);

        invertBinaryTree.invertTree(root);

        Assert.assertEquals(10, root.val);
        Assert.assertEquals(15, root.left.val);
        Assert.assertEquals(5, root.right.val);
    }

    @Test
    public void invertTree1() {
        Assert.assertEquals(null, invertBinaryTree.invertTree(null));
        TreeNode root = new TreeNode(10);
        Assert.assertEquals(10, invertBinaryTree.invertTree(root).val);
    }


}