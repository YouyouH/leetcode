package com.yy.leetcode.linkedlist;

/**
 * @author youyouhuang
 * @create 2020-03-20
 * @desc https://leetcode.com/problems/swap-nodes-in-pairs/
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 **/

public class SwapNodesinPairs {

    //原地交换
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode pNode = root;

        //当下面的while条件不满足时就直接返回head
        root.next = head;

        //两个两个的交换，换到最后单一个就不用换了。
        while (head != null && head.next != null) {
            ListNode slow = head;
            ListNode fast = head.next;

            //swap node
            slow.next = fast.next;
            fast.next = slow;

            pNode.next = fast;
            pNode = slow;
            head = slow.next;
        }
        return root.next;
    }
}
