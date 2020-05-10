package com.yy.leetcode.jianzhioffer;
/**
 * @author youyouhuang
 * @create 2020-05-10
 **/

import com.yy.leetcode.linkedlist.ListNode;

/**
 *
 *<p>
 *定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *</p>
 **/
public class ReverseLinkedList {
    /**
     * 1-2-3-4-NULL
     * 4-3-2-1-NULL
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
