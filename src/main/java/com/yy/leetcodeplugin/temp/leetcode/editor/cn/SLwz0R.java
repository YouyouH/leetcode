//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：能尝试使用一趟扫描实现吗？ 
//
// 
//
// 注意：本题与主站 19 题相同： https://leetcode-cn.com/problems/remove-nth-node-from-end-
//of-list/ 
// Related Topics 链表 双指针 👍 22 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-10 21:13:14
//删除链表的倒数第 n 个结点

import com.yy.leetcode.linkedlist.ListNode;

public class SLwz0R{
    public static void main(String[] args) {
         Solution solution = new SLwz0R().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针，间隔n
        ListNode p1 = head;
        ListNode p2 = head;
        //先调整距离
        while (n-- > 0) {
            p2 = p2.next;
        }
        if (p2 == null) {
            return head.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        //为什么不是p1.next = p2???
        // 因为p1就是要删除的节点的前一个节点，所以用这种方式刚好跳过要被删除的下一个节点
        p1.next = p1.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}