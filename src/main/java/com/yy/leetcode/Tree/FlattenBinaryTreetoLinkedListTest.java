package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlattenBinaryTreetoLinkedListTest {

    FlattenBinaryTreetoLinkedList flattenBinaryTreetoLinkedList = new FlattenBinaryTreetoLinkedList();

    @Test
    public void flatten() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = null;
        root.right.right = new TreeNode(18);
        flattenBinaryTreetoLinkedList.flatten1(root);
        Assert.assertEquals(10,root.val);
        Assert.assertEquals(5,root.right.val);
        Assert.assertEquals(3,root.right.right.val);
        Assert.assertEquals(7,root.right.right.right.val);
        Assert.assertEquals(15,root.right.right.right.right.val);
        Assert.assertEquals(18,root.right.right.right.right.right.val);
    }
}