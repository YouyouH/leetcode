package com.yy.leetcode.twopointers;

import com.yy.leetcode.linkedlist.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class linkedlistcycleii {

    /**
     * _ _ _ _ _ _ _ _ _
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if(head == head.next) return head;
        ListNode p = head;
        while (true) {
            ListNode p1 = p;
            ListNode p2 = p.next;
            if(p1 == p2) return p1;
            while (p1 != p2) {
                if (null == p2) return null;

                p1 = p1.next;

                p2 = p2.next;
                if (p2 == p) return p;
                if (p2 == null) return null;
                p2 = p2.next;
                if (p2 == p) return p;
                if (p2 == null) return null;
            }
            p = p.next;
        }
    }
}
