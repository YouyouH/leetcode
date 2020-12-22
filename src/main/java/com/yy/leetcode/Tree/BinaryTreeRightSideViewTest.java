package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeRightSideViewTest {

    BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();

    @Test
    public void rightSideView() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = null;
        root.right.right = new TreeNode(18);
        List<Integer> integers = binaryTreeRightSideView.rightSideView(root);
        Assert.assertArrayEquals(new Integer[]{10, 15, 18}, integers.toArray());
    }

    @Test
    public void rightSideView2() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        List<Integer> integers = binaryTreeRightSideView.rightSideView(root);
        Assert.assertArrayEquals(new Integer[]{10,5}, integers.toArray());
    }

    @Test
    public void rightSideView3() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = null;
        root.right.right = new TreeNode(18);
        List<Integer> integers = binaryTreeRightSideView.rightSideView2(root);
        Assert.assertArrayEquals(new Integer[]{10, 15, 18}, integers.toArray());
    }

}