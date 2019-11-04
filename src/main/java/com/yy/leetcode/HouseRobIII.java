package com.yy.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author youyouhuang
 * @create 2019-09-19
 * @desc
 **/

public class HouseRobIII {

    public int rob(TreeNode root) {

        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList();

        Queue<TreeNode> treeNodes = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(null == node){
                treeNodes.add(new TreeNode(0));
                continue;
            }
            treeNodes.add(node);
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (null == left && null == right) {
                treeNodes.add(new TreeNode(0));
                treeNodes.add(new TreeNode(0));
                continue;
            }
            //null is fine if only one child is null
            queue.add(left);
            queue.add(right);
        }
        int size = treeNodes.size();

        List<Integer> nums = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            if(treeNodes.size() == 0){
                break;
            }
            double length = Math.pow(2, i);
            int tmp = 0;
            for (int j = 0; j < length; j++) {
                TreeNode treeNode = treeNodes.poll();
                if (null == treeNode) {
                    continue;
                }
                tmp += treeNode.val;
            }
            nums.add(tmp);
        }


        int length = nums.size();
        if (length == 1) {
            return nums.get(0);
        }
        if (length == 2) {
            return Math.max(nums.get(0), nums.get(1));
        }
        int[] memo = new int[2];
        int result = 0;
        memo[0] = nums.get(0);
        memo[1] = nums.get(1);
        for (int k = 3; k <= length; k++) {
            result = Math.max(memo[0] + nums.get(k-1), memo[1]);
            memo[0] = memo[1];
            memo[1] = result;
        }
        return result;
    }
}





class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
