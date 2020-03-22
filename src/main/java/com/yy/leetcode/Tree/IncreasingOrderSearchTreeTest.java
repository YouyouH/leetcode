package com.yy.leetcode.Tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncreasingOrderSearchTreeTest {

    /**
     *  [5,3,6,2,4,null,8,1,null,null,null,7,9]
     */
    @Test
    public void increasingBST() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        IncreasingOrderSearchTree orderSearchTree = new IncreasingOrderSearchTree();
        orderSearchTree.increasingBST(root);
    }
}