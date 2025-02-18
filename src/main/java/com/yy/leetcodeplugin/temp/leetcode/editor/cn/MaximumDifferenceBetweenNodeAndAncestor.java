
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-18 16:38:50 
//节点与其祖先之间的最大差值

public class MaximumDifferenceBetweenNodeAndAncestor{
    public static void main(String[] args) {
         Solution solution = new MaximumDifferenceBetweenNodeAndAncestor().new Solution();
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
    public int maxAncestorDiff(TreeNode root) {
        /**
         * 对于每一个节点，保存其父节点中的最大值和最小值（因为绝对值要最大）。
         */
        traverse(root,root.val,root.val);

        return ans;
        
    }

    private void traverse(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }

        ans = Math.max(ans, Math.max(Math.abs(max - root.val), Math.abs(min - root.val)));

        traverse(root.left, Math.max(max, root.val), Math.min(min, root.val));
        traverse(root.right, Math.max(max, root.val), Math.min(min, root.val));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。 
//
//
// （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先） 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
//输出：7
//解释： 
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,null,2,null,0,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 2 到 5000 之间。 
// 0 <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 286 👎 0
