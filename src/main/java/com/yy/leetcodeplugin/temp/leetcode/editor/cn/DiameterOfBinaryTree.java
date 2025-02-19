
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-19 22:12:39 
//二叉树的直径

public class DiameterOfBinaryTree{
    public static void main(String[] args) {
         Solution solution = new DiameterOfBinaryTree().new Solution();
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
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        traverse(root);

        return max;
        
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == root.right) {//到叶子节点了
            return 0;
        }

        int leftDepth = 0, rightDepth = 0;
        if (root.left != null) {
            leftDepth = traverse(root.left) + 1;
        }

        if (root.right != null) {
            rightDepth = traverse(root.right) + 1;
        }


        max = Math.max(max, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一棵二叉树的根节点，返回该树的 直径 。 
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1658 👎 0
