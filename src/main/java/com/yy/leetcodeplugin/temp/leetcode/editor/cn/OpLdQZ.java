  ////给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
// 
////
//// 
////
//// 示例 1： 
////
//// 
////输入: root = [8,6,10,5,7,9,11], k = 12
////输出: true
////解释: 节点 5 和节点 7 之和等于 12
//// 
////
//// 示例 2： 
////
//// 
////输入: root = [8,6,10,5,7,9,11], k = 22
////输出: false
////解释: 不存在两个节点值之和为 22 的节点
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 二叉树的节点个数的范围是 [1, 10⁴]. 
//// -10⁴ <= Node.val <= 10⁴ 
//// root 为二叉搜索树 
//// -10⁵ <= k <= 10⁵ 
//// 
////
//// 
////
//// 注意：本题与主站 653 题相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-
//bst/
//// 
//// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 14 👎 0
//

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-28 13:09:33 
//二叉搜索树中两个节点之和

  import java.util.HashSet;
  import java.util.Set;

  public class OpLdQZ{
    public static void main(String[] args) {
         Solution solution = new OpLdQZ().new Solution();
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

    private Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        //这个思路不好，可以用二叉搜索树的特性，中序遍历为升序，再双指针搜索
        traverseTree(root);
        for (Integer num : set) {
            if (num == k - num) {
                //节点值唯一
                continue;
            }
            if (set.contains(k - num)) {
                return true;
            }
        }
        return false;

    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        traverseTree(root.left);
        traverseTree(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}