package com.yy.leetcode.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    //层次遍历
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        List<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            result.add(queue.get(queue.size() - 1).val);

            while (size-- > 0) {
                TreeNode node = queue.remove(0);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    //深度遍历
    public List<Integer> rightSideView2(TreeNode root) {

        List<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result, int depth) {
        if (null == root) {
            return;
        }
        if (result.size() == depth) {
            result.add(root.val);
        }
        depth++;
        dfs(root.right, result, depth);
        dfs(root.left, result, depth);
    }
}
