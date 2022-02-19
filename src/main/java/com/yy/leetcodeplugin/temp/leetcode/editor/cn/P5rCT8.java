  ////给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。 
////
//// 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。 
////
//// 
////
//// 示例 1： 
////
//// 
////
//// 
////输入：root = [2,1,3], p = 1
////输出：2
////解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
//// 
////
//// 示例 2： 
////
//// 
////
//// 
////输入：root = [5,3,6,2,4,null,null,1], p = 6
////输出：null
////解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 树中节点的数目在范围 [1, 10⁴] 内。 
//// -10⁵ <= Node.val <= 10⁵ 
//// 树中各节点的值均保证唯一。 
//// 
////
//// 
////
//// 注意：本题与主站 285 题相同： https://leetcode-cn.com/problems/inorder-successor-in-
//bst/ 
////
//// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 16 👎 0
//

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-19 11:47:44 
//二叉搜索树中的中序后继

  import java.util.LinkedList;
  import java.util.List;

  public class P5rCT8{
    public static void main(String[] args) {
         Solution solution = new P5rCT8().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private LinkedList<TreeNode> res = new LinkedList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //基本的中序遍历，然后用链表保存
        traverseTree(root, p);
        return res.indexOf(p) + 1 == res.size() ? null : res.get(res.indexOf(p) + 1);
    }

    private void traverseTree(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        traverseTree(root.left, p);
        res.add(root);
        traverseTree(root.right, p);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}