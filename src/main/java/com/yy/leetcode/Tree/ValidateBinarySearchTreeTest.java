package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {

    @Test
    public void isValidBST0() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        Assert.assertEquals(true,validateBinarySearchTree.isValidBST(root));
    }
    @Test
    public void isValidBST() {
        //[5,1,4,null,null,3,6]
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        Assert.assertEquals(false,validateBinarySearchTree.isValidBST(root));
    }

    @Test
    public void isValidBST1() {
        TreeNode root = new TreeNode(0);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        Assert.assertEquals(true,validateBinarySearchTree.isValidBST(root));
    }

    @Test
    public void isValidBST2() {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        Assert.assertEquals(true,validateBinarySearchTree.isValidBST(root));
    }

    @Test
    public void isValidBST3() {
        //[10,5,15,null,null,6,20]
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        Assert.assertEquals(false,validateBinarySearchTree.isValidBST(root));
    }
}