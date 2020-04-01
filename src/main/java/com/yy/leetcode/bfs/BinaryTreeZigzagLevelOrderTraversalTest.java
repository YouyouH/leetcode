package com.yy.leetcode.bfs;

import com.yy.leetcode.Tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BinaryTreeZigzagLevelOrderTraversalTest {

    BinaryTreeZigzagLevelOrderTraversal zigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();

    @Test
    public void zigzagLevelOrder() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = null;
        root.right.right = new TreeNode(18);

        List<List<Integer>> results = zigzagLevelOrderTraversal.zigzagLevelOrder(root);

        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : results) {
            for (Integer integer : list) {
                result.add(integer);
            }
        }
        Assert.assertArrayEquals(new Integer[]{10,15,5,3,7,18}, result.toArray(new Integer[0]));
    }
}