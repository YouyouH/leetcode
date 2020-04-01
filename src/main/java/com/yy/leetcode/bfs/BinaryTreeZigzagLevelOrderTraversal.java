package com.yy.leetcode.bfs;

import com.yy.leetcode.Tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author youyouhuang
 * @create 2020-04-01
 * @desc https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 **/

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<LinkedList<TreeNode>> list = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(null == root){
            return result;
        }
        LinkedList<TreeNode> rootNode = new LinkedList<>();
        rootNode.offer(root);
        list.offer(rootNode);
        LinkedList<Integer> rootVal = new LinkedList<>();
        rootVal.offer(root.val);
        result.add(rootVal);

        boolean seq = true;

        while (!list.isEmpty()) {
            List<TreeNode> treeNodes = list.poll();
            LinkedList<TreeNode> tmpNodes = new LinkedList<>();
            LinkedList<Integer> tmpValues = new LinkedList<>();
            if (seq) {
                for (int i = treeNodes.size() - 1; i >= 0; i--) {
                    TreeNode node = treeNodes.get(i);
                    if (node.right != null) {
                        TreeNode right = node.right;
                        tmpNodes.offer(right);
                        tmpValues.offer(right.val);
                    }
                    if (node.left != null) {
                        TreeNode left = node.left;
                        tmpNodes.offer(left);
                        tmpValues.offer(left.val);
                    }
                }
            } else {
                for (int i = treeNodes.size() - 1; i >= 0; i--) {
                    TreeNode node = treeNodes.get(i);
                    if (node.left != null) {
                        TreeNode left = node.left;
                        tmpNodes.offer(left);
                        tmpValues.offer(left.val);
                    }
                    if (node.right != null) {
                        TreeNode right = node.right;
                        tmpNodes.offer(right);
                        tmpValues.offer(right.val);
                    }
                }
            }
            if (!tmpValues.isEmpty()) {
                result.add(tmpValues);
            }
            if (!tmpNodes.isEmpty()) {
                list.offer(tmpNodes);
            }
            seq = !seq;
        }
        return result;
    }

}
