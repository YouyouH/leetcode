
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-16 20:22:07 
//统计二叉树中好节点的数目

public class CountGoodNodesInBinaryTree{
    public static void main(String[] args) {
         Solution solution = new CountGoodNodesInBinaryTree().new Solution();
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
    /**
     * FIXME: 递归的时候维护一个当前路径的max
     */
    public int goodNodes(TreeNode root) {
        return traverse(root, root.val);
    }

    private int traverse(TreeNode root, int max) {
        if (null == root) {
            return 0;
        }

        int cur = root.val;
        int add = 0;
        if (cur >= max) {
            add = 1;
        }
        if (cur > max) {
            max = cur;
        }

        return traverse(root.left, max) + traverse(root.right, max) + add;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。 
//
// 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [3,1,4,3,null,1,5]
//输出：4
//解释：图中蓝色节点为好节点。
//根节点 (3) 永远是个好节点。
//节点 4 -> (3,4) 是路径中的最大值。
//节点 5 -> (3,4,5) 是路径中的最大值。
//节点 3 -> (3,1,3) 是路径中的最大值。 
//
// 示例 2： 
//
// 
//
// 输入：root = [3,3,null,4,2]
//输出：3
//解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。 
//
// 示例 3： 
//
// 输入：root = [1]
//输出：1
//解释：根节点是好节点。 
//
// 
//
// 提示： 
//
// 
// 二叉树中节点数目范围是 [1, 10^5] 。 
// 每个节点权值的范围是 [-10^4, 10^4] 。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 185 👎 0
