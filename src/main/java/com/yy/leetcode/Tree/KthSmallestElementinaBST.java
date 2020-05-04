package com.yy.leetcode.Tree;
/**
 * @author youyouhuang
 * @create 2020-05-04
 **/

import java.util.LinkedList;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历
        //递归不方便退出，用栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        int i = 0;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode pop = stack.pop();
                if (++i == k) {
                    return pop.val;
                }
                pNode = pop.right;
            }
        }
        return 0;
    }
}
