package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructStringFromBinaryTreeTest {
    ConstructStringFromBinaryTree constructStringFromBinaryTree = new ConstructStringFromBinaryTree();

    @Test
    public void tree2str() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        Assert.assertEquals("1(2(4))(3)",constructStringFromBinaryTree.tree2str(root));
    }

    @Test
    public void tree2str2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);

        Assert.assertEquals("1(2()(4))(3)",constructStringFromBinaryTree.tree2str(root));
    }
}