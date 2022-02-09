////给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
////
//// 假设二叉树中至少有一个节点。 
////
//// 
////
//// 示例 1: 
////
//// 
////
//// 
////输入: root = [2,1,3]
////输出: 1
//// 
////
//// 示例 2: 
////
//// 
////
//// 
////输入: [1,2,3,4,null,5,6,null,null,7]
////输出: 7
//// 
////
//// 
////
//// 提示: 
////
//// 
//// 二叉树的节点个数的范围是 [1,10⁴] 
//// -2³¹ <= Node.val <= 2³¹ - 1 
//// 
////
//// 
////
//// 注意：本题与主站 513 题相同： https://leetcode-cn.com/problems/find-bottom-left-tree-
////value/ 
//// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 13 👎 0
//


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-09 14:32:04
//二叉树最底层最左边的值

public class LwUNpT{
    public static void main(String[] args) {
         Solution solution = new LwUNpT().new Solution();
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
    private int maxLength = Integer.MIN_VALUE;
    private int result = 0;
    public int findBottomLeftValue(TreeNode root) {
        //广度优先搜索,不用练习了，问题不大。

        //[抄的答案]考虑深度搜索，递归，确定最大深度从而找到最左边的值.
        traverseTree(root,0);
        return result;
    }

    private void traverseTree(TreeNode root, int curMaxLength) {
        //终止条件：递归到最后一层
        if (root.left == null && root.right == null) {
            //为什么不能像正常的遍历二叉树那样，直接判断null == root然后返回呢？？
            //因为这里需要取最后一层的值，所以做了一些变形，跟标准的遍历二叉树不一样。
            if (curMaxLength > maxLength) {
                maxLength = curMaxLength;
                result = root.val;
                return;
            }
        }
        if (null != root.left) {
            traverseTree(root.left, curMaxLength + 1);
        }

        if (null != root.right) {
            traverseTree(root.right,curMaxLength+1);
        }
        return;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}