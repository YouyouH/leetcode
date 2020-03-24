package com.yy.leetcode.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-03-24
 * @desc https://leetcode.com/problems/path-sum-ii/
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 **/

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results= new LinkedList<>();

        LinkedList<Integer> current = new LinkedList<>();

        traverseTree(root,sum,current,results);
        return results;
    }

    private void traverseTree(TreeNode root, int sum, LinkedList<Integer> current, List<List<Integer>> results) {
        if(root == null){
            return;
        }
        current.addLast(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            results.add(new LinkedList<>(current));
        }else{
            traverseTree(root.left,sum-root.val,current,results);
            traverseTree(root.right,sum - root.val,current,results);
        }
        current.removeLast();
    }

}
