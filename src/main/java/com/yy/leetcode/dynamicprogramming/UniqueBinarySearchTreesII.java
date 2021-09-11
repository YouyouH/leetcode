package com.yy.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {

    //递归
    public List<TreeNode> generateTrees(int n) {

        if(n < 1) return new ArrayList<>();

        List<TreeNode> treeNodes = generateTreeNode(1, n);
        return treeNodes;
    }

    private List<TreeNode> generateTreeNode(int start, int n) {
        List<TreeNode> result = new ArrayList();

        if (start > n) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= n; i++) {
            TreeNode root = new TreeNode(i);

            List<TreeNode> leftNodes = generateTreeNode(start, i - 1);
            List<TreeNode> rightNodes = generateTreeNode(i + 1, n);

            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root0 = new TreeNode(root.val);
                    root0.left = leftNode;
                    root0.right = rightNode;
                    result.add(root0);
                }
            }
        }
        return result;

    }

}
