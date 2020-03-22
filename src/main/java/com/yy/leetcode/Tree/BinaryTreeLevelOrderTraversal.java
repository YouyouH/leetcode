package com.yy.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-03-22
 * @desc https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7]
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 **/

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null == root){
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                list.add(node.val);
                tmp.add(node);
            }
            results.add(list);

            while (!tmp.isEmpty()) {
                TreeNode tmpNode = tmp.remove();
                if (null != tmpNode.left) {
                    queue.offer(tmpNode.left);
                }
                if (null != tmpNode.right) {
                    queue.offer(tmpNode.right);
                }
            }
        }
        return results;
    }
}
