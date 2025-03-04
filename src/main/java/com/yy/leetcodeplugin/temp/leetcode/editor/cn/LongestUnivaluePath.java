
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-04 11:07:26 
//最长同值路径

public class LongestUnivaluePath{
    public static void main(String[] args) {
         Solution solution = new LongestUnivaluePath().new Solution();
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
    private int ans = 0;
    public int longestUnivaluePath(TreeNode root) {

        traverse(root);
        return ans == 0 ? 0 : ans - 1;
        
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == root.right) {//到了叶子节点
            return 1;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        //length 表示经过当前节点的最长路径（当前节点不为根节点）
        //分三种情况：1.跟左边连起来 2.跟右边连起来 3.跟两边都连不起来，只有自己。 三种取最大值
        int length = 1;
        if (null == root.left || root.val == root.left.val) {
            length = Math.max(length, 1 + left);
        }

        if (null == root.right || root.val == root.right.val) {
            length = Math.max(length, 1 + right);
        }

        if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            //如果左边等于右边，则当前节点可以和左右两边同时连起来
            ans = Math.max(ans, 1 + left + right);
        }else{
            //左边不等于右边，则最多只能跟一边连起来
            ans = Math.max(ans, length);
        }
//        System.out.println("root="+root.val+" length="+length);
        return length;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [1,4,5,4,4,5]
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树的节点数的范围是
// [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 825 👎 0
