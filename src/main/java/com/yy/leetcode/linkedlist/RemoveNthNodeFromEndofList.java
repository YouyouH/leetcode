package com.yy.leetcode.linkedlist;

/**
 * @author youyouhuang
 * @create 2020-03-20
 * @desc https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 **/

public class RemoveNthNodeFromEndofList {

    /**
     * 只遍历一次链表
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0){
            return head;
        }
        //两个指针一起移动，中间距离是n,前一个到底的时候后一个就是被删除的。
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0; i<n;i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
