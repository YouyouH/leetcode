
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-14 22:30:33 
//左叶子之和

public class SumOfLeftLeaves{
    public static void main(String[] args) {
         Solution solution = new SumOfLeftLeaves().new Solution();
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
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        //FIXME: 只要叶子，即没有任何子结点
        traverseTree(root);
        return sum;
    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left==null && root.left.right==null) {
            sum += root.left.val;
        }
        traverseTree(root.left);

        traverseTree(root.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定二叉树的根节点 root ，返回所有左叶子之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 758 👎 0
