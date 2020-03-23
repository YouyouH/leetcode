package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-23
 * @desc https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历，判断是不是递增序列
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        traverseTree(root, values);
        for (int i = 1; i < values.size(); i++) {
            if(values.get(i) <= values.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void traverseTree(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        traverseTree(root.left, values);
        values.add(root.val);
        traverseTree(root.right, values);
    }
}
