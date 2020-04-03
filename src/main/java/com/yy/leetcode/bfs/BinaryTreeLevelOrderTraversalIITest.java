package com.yy.leetcode.bfs;

import com.yy.leetcode.Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeLevelOrderTraversalIITest {
    BinaryTreeLevelOrderTraversalII traversalII = new BinaryTreeLevelOrderTraversalII();
    @Test
    public void levelOrderBottom() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = null;
        root.right.right = new TreeNode(18);

        List<List<Integer>> result = traversalII.levelOrderBottom(root);
        Assert.assertArrayEquals(new Integer[][]{{3,7,18},{5,15},{10}},result.stream().map(a->a.toArray()).toArray());
    }
}