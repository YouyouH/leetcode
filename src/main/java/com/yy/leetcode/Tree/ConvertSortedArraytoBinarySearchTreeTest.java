package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertSortedArraytoBinarySearchTreeTest {

    @Test
    public void sortedArrayToBST() {
        ConvertSortedArraytoBinarySearchTree searchTree = new ConvertSortedArraytoBinarySearchTree();
        TreeNode treeNode = searchTree.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        Assert.assertEquals(0,treeNode.val);
        Assert.assertEquals(-3,treeNode.left.val);
        Assert.assertEquals(-10,treeNode.left.left.val);
    }
}