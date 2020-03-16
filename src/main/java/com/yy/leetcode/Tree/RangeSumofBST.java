package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-16
 * @desc 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 **/

import java.util.LinkedList;

/**
 * 求二叉树 中序 遍历。两种方式，递归 和 遍历。
 * 采用遍历的方式比较好计算sum
 */
public class RangeSumofBST {

    public int rangeSumBST(TreeNode root, int L, int R) {

        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> stack = new LinkedList();

        int sum = 0;

        boolean start = false;

        while (root != null || !stack.isEmpty()) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (node != null) {
                    System.out.println(node.val);
                    if (node.val == L) {
                        start = true;
                    }

                    if (start) {
                        sum += node.val;
                    }
                    if (node.val == R) {
                        start = false;
                    }
                }
                root = node.right;
            }
        }
        return sum;
    }

}
