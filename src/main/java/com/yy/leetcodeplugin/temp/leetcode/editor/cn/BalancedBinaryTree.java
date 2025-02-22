
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-22 11:26:43 
//平衡二叉树

public class BalancedBinaryTree{
    public static void main(String[] args) {
         Solution solution = new BalancedBinaryTree().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        /**
         * FIXME: 递归每一个点，同时对每一个点在递归求高度
         */
        if (root == null) {
            return true;
        } else {
            return Math.abs(traverse(root.left) - traverse(root.right)) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == root.right) {
            return 1;
        }

        return Math.max(traverse(root.left), traverse(root.right)) + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个二叉树，判断它是否是 平衡二叉树 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1579 👎 0
