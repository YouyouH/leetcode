
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-12 12:51:50 
//旋转链表

public class RotateList{
    public static void main(String[] args) {
         Solution solution = new RotateList().new Solution();
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
    public ListNode rotateRight(ListNode head, int k) {
        /**
         * 先定位到3，然后把3断开。再把5接到head上
         * 另外K很大的时候要先除以链表长度。
         */
        if (k == 0 ||  head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();

        ListNode cur = head;

        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        k = k % length;

        if (k == 0) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        ListNode newHead = p1.next;
        p1.next = null;
        p2.next = head;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 1119 👎 0
