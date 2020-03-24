package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricTreeTest {

    SymmetricTree symmetricTree = new SymmetricTree();

    @Test
    public void isSymmetric() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = null;
        root.right.right = new TreeNode(18);

        Assert.assertEquals(false,symmetricTree.isSymmetric(root));
    }

    @Test
    public void isSymmetric1() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Assert.assertEquals(true,symmetricTree.isSymmetric(root));
    }

    @Test
    public void isSymmetric2() {
        TreeNode root = new TreeNode(1);
        Assert.assertEquals(true,symmetricTree.isSymmetric(root));
    }
}