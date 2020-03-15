package com.yy.leetcode.linkedlist;


/**
 * @author youyouhuang
 * @create 2020-03-12
 * @desc
 **/

/**
 * 对于新生成的list,设置一个哨兵节点prehead 和前置指针 pre。往哨兵节点后面追加节点。
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //prehead是新list 的头
        ListNode prehead = new ListNode(-1);

        //指针用来往新生成的list后面追加node
        ListNode pre = prehead;

        //遍历l1,l2
        return merge(l1, l2, pre, prehead);

    }

    private ListNode merge(ListNode l1, ListNode l2, ListNode pre, ListNode prehead) {
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return prehead.next;

    }
}

