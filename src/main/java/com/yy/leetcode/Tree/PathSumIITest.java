package com.yy.leetcode.Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PathSumIITest {

    @Test
    public void pathSum() {
        PathSumII pathSumII = new PathSumII();

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> pathSum = pathSumII.pathSum(root, 22);

        Assert.assertEquals(true,sum(pathSum,22));
    }

    private boolean sum(List<List<Integer>> pathSum, int sum) {
        boolean result = true;
        for (List<Integer> integers : pathSum) {
            if(22 != integers.stream().mapToInt(number->number).sum()){
                result =false;
            }
        }
        return result;

    }
}