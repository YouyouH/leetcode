package com.yy.leetcode.bfs;

import com.yy.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-04-03
 * @desc https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 **/

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null ){
            return result;
        }

        LinkedList<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(root);
        while (!levelNodes.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            LinkedList<Integer> tmpVal = new LinkedList<>();
            while (!levelNodes.isEmpty()) {
                TreeNode node = levelNodes.poll();
                tmpVal.add(node.val);
                if (node.left != null) {
                    tmp.offer(node.left);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }
            }
            if (!tmp.isEmpty()) {
                levelNodes.addAll(tmp);
            }
            if (!tmpVal.isEmpty()) {
                result.add(tmpVal);
            }
        }
        List<List<Integer>> result0 = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            result0.add(result.get(i));
        }
        return result0;
    }
}
