
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-11 23:15:56 
//删除链表的倒数第 N 个结点

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
         Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p1 = head;
        ListNode p2 = head;//p2用来确认终点

        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        if (null == p2) {
            return p1.next;
        }

        while (p2.next != null) {
            p2 = p2.next;

            p1 = p1.next;

        }
        p1.next = p1.next.next;

        return dummy.next;

        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
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
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 3021 👎 0
