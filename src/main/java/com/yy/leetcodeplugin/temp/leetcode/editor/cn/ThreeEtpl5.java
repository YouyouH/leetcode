  //给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。 
//
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
//
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
// 
// 
//
// 
//
// 注意：本题与主站 129 题相同： https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/ 
//
// Related Topics 树 深度优先搜索 二叉树 👍 14 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-12 13:39:20 
//从根节点到叶节点的路径数字之和

  import java.util.ArrayList;
  import java.util.List;

  public class ThreeEtpl5{
    public static void main(String[] args) {
         Solution solution = new ThreeEtpl5().new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        solution.sumNumbers(root);
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
    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverseTree(root, new StringBuilder(),res);
        int sum = 0;
        for (Integer num : res) {
            sum += num;
        }
        return sum;
    }

    private void traverseTree(TreeNode root, StringBuilder stringBuilder, List<Integer> res) {
        if (root == null) {
            return;
        }

        stringBuilder.append(root.val);

        //到达叶子节点了就计算路径
        if (root.left == null && root.right ==null) {
            res.add(Integer.valueOf(stringBuilder.toString()));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return;
        }

        traverseTree(root.left,stringBuilder,res);

        traverseTree(root.right,stringBuilder,res);

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}