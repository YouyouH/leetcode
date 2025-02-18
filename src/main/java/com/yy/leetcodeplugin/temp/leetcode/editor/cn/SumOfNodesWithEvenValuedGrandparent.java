
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-18 13:27:30 
//祖父节点值为偶数的节点和

public class SumOfNodesWithEvenValuedGrandparent{
    public static void main(String[] args) {
         Solution solution = new SumOfNodesWithEvenValuedGrandparent().new Solution();
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
    int res = 0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val % 2 == 0) {//当前是偶数，找孙子节点
            int left = calculate(root.left);
            int right = calculate(root.right);
//            System.out.println("cur=" + root.val + " left=" + left + " right=" + right);
            res += left + right;
        }
        if ((root.left == null || root.left.left == root.left.right) && (root.right == null || root.right.left == root.right.right)) {
            //没有孙子了
            return;
        }

        traverse(root.left);
        traverse(root.right);

    }

    private int calculate(TreeNode root) {
        int sum = 0;
        if (null != root) {
            if (root.left != null) {
                sum += root.left.val;
            }
            if (root.right != null) {
                sum += root.right.val;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一棵二叉树，请你返回满足以下条件的所有节点的值之和： 
//
// 
// 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。） 
// 
//
// 如果不存在祖父节点值为偶数的节点，那么返回 0 。 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：18
//解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在 1 到 10^4 之间。 
// 每个节点的值在 1 到 100 之间。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 102 👎 0
