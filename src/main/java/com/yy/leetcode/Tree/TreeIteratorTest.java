package com.yy.leetcode.Tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeIteratorTest {

    TreeIterator treeIterator = new TreeIterator();
    TreeNode root = null;

    @Before
    public void setUp() throws Exception {
        root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = null;
        root.right.right = new TreeNode(18);
    }

    @Test
    public void preOrderTraverse() {
        treeIterator.preOrderTraverse(root);
    }

    @Test
    public void inOrderTraverse() {
        treeIterator.inOrderTraverse(root);
    }

    @Test
    public void postOrderTraverse1() {
        treeIterator.postOrderTraverse1(root);
    }

    @Test
    public void preOrderTraverse1() {
        treeIterator.preOrderTraverse1(root);
    }

    @Test
    public void inOrderTraverse1() {
        treeIterator.inOrderTraverse1(root);
    }

    @Test
    public void levelTraverse() {
        treeIterator.levelTraverse(root);
    }
}