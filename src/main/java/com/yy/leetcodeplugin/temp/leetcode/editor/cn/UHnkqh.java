//给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
//
// 
//
// 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 👍 43 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-15 18:15:22
//反转链表

import com.yy.leetcode.linkedlist.ListNode;

public class UHnkqh{
    public static void main(String[] args) {
         Solution solution = new UHnkqh().new Solution();
         ListNode _1 = new ListNode(1);
         ListNode _2 = new ListNode(2);
         ListNode _3 = new ListNode(3);
         ListNode _4 = new ListNode(4);
         ListNode _5 = new ListNode(5);

        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;

        solution.reverseList(_1);
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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = null;
        ListNode p2 = head;

        while (p2.next != null) {
            ListNode next = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = next;
        }
        p2.next = p1;

        return p2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}