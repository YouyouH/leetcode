package com.yy.leetcode.linkedlist;

/**
 * @author youyouhuang
 * @create 2020-03-20
 * @desc https://leetcode-cn.com/problems/odd-even-linked-list/
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 **/

public class OddEvenLinkedList {
    /**
     * 生成两个链表，奇数链表和偶数链表。再组合起来
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode pNode1 = dummy1;
        ListNode pNode2 = dummy2;

        while (head != null && head.next != null) {
            pNode1.next = head;
            pNode1 = pNode1.next;
            pNode2.next = head.next;
            pNode2 = pNode2.next;
            head = head.next.next;
        }
        if(head !=null){
            pNode1.next = head;
            pNode1 = pNode1.next;
            pNode2.next = null;
        }

        //把dummy2 接到dummmy1最后
        pNode1.next = dummy2.next;
        return dummy1.next;
    }
}
