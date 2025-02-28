
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-26 22:03:09 
//二叉树中的最大路径和

public class BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
         Solution solution = new BinaryTreeMaximumPathSum().new Solution();
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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        /**
         * FIXME 看的答案
         *  递归求每个点的 最大贡献和。例如对于节点20，最大贡献和等于 15，即左右两边叶子节点中的最大贡献和再加上自己。
         *  全局记录每个节点的路径和，并且不断的更新答案。了；例如对于节点20，路径和为左边节点的最大贡献 加上 右边节点的最大贡献，还要再加上自己。 20+15+7
         *   另外如果是负数就不要加进去
         */

        traverse(root);

        return ans;
        
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        ans = Math.max(ans, Math.max(0, left) + Math.max(0, right) + root.val);

        int max = Math.max(left, right);
        return root.val + (Math.max(max, 0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 2353 👎 0
