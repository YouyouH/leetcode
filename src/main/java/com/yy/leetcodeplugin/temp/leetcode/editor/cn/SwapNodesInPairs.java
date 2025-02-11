
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-10 22:19:47 
//两两交换链表中的节点

public class SwapNodesInPairs{
    public static void main(String[] args) {
         Solution solution = new SwapNodesInPairs().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        /**
         * FIXME 看的答案
         *      //temp->node2->node1
         *
         */
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode node1;
        ListNode node2;
        ListNode temp = dummy;

        while (temp.next != null && temp.next.next != null) {
            node1 = temp.next;
            node2 = temp.next.next;

            ListNode next = node2.next;
            //temp->node2->node1
            temp.next = node2;
            node2.next = node1;
            node1.next = next;

            temp = node1;

        }
        return dummy.next;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2347 👎 0
