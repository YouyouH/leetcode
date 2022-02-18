  //给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// 
//
// 注意：本题与主站 437 题相同：https://leetcode-cn.com/problems/path-sum-iii/ 
// Related Topics 树 深度优先搜索 二叉树 👍 16 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-12 14:09:14 
//向下的路径节点之和

  import java.util.HashMap;
  import java.util.Map;

  public class SixEUYwP{
    public static void main(String[] args) {
         Solution solution = new SixEUYwP().new Solution();
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
    private int res = 0;
    private int target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        //方法一：递归找每一个node，再对每一个node递归，判断是否有路径满足条件。双重递归
        //方法二：递归遍历树 + 前缀和

        //方法二：
        Map<Integer, Integer> preSum = new HashMap<>();//val to
        preSum.put(0, 1);
        target = targetSum;
        traverseTree(root,0, preSum);

        return res;

    }

    private void traverseTree(TreeNode root, int sum, Map<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }

        //通过前缀和计算有没有满足条件的. 注意要先计算，在更新前缀和
        res += preSum.getOrDefault(root.val + sum - target, 0);


        preSum.put(root.val + sum, preSum.getOrDefault(root.val + sum, 0) + 1);

        traverseTree(root.left, root.val + sum, preSum);
        traverseTree(root.right, root.val + sum, preSum);

        preSum.put(root.val + sum, preSum.getOrDefault(root.val + sum, 0) - 1);

    }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        private int res = 0;
        public int pathSum(TreeNode root, int targetSum) {
            //方法一：递归找每一个node，再对每一个node递归，判断是否有路径满足条件。双重递归
            //方法二：递归遍历树 + 前缀和

            //方法一
            traverseTree(root, targetSum);
            return res;
        }

        private void traverseTree(TreeNode root, int targetSum) {
            //先遍历每一个节点
            if (root == null) {
                return;
            }
            //对每一个节点再次深度遍历
            dfs2(root, root.val,targetSum);
            traverseTree(root.left, targetSum);
            traverseTree(root.right, targetSum);
        }

        private void dfs2(TreeNode root, int sum, int targetSum) {

            if (sum == targetSum) {
                res++;
            }
            if (root.left != null) {
                dfs2(root.left, sum + root.left.val, targetSum);
            }

            if (root.right != null) {
                dfs2(root.right, sum + root.right.val, targetSum);
            }

        }
}