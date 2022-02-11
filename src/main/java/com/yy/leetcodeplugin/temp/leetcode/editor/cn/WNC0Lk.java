  //给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 注意：本题与主站 199 题相同：https://leetcode-cn.com/problems/binary-tree-right-side-
//view/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 16 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-11 14:19:36 
//二叉树的右侧视图

  import java.util.ArrayList;
  import java.util.List;

  public class WNC0Lk{
    public static void main(String[] args) {
         Solution solution = new WNC0Lk().new Solution();
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
    public List<Integer> rightSideView(TreeNode root) {
        //方法一：广度优先遍历，然后取每一层的最后一个节点。（太简单了不写了）

        //方法二：深度优先遍历，递归。抄的答案！！！！！！！！！！！
        ArrayList<Integer> res = new ArrayList<>();
        traverseTree(root,res,0);
        return res;
    }

    private void traverseTree(TreeNode root, ArrayList<Integer> res, int depth) {
        //递归终止条件：
        if (root == null) {
            return;
        }
        //res的size就是树的深度
        if (depth == res.size()) {
            res.add(root.val);
        }


        //先遍历右边，再遍历左边
        traverseTree(root.right, res,depth+1);
        traverseTree(root.left, res,depth+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}