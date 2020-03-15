package com.yy.leetcode.linkedlist;

/**
 * @author youyouhuang
 * @create 2020-03-15
 * @desc Sort a linked list in O(n log n) time using constant space complexity.
 **/

import com.yy.mergesort.MergeSort;

/**
 * 解法一: 自上而下的归并排序,{@link MergeSort}.
 *
 * 1.将list 拆分。使用快慢指针法。快指针速度是慢指针两倍，这样当快指针移动到末尾时慢指针移动到了中间。
 * 2.递归第一步，知道list全部拆开。
 * 3.merge two sorted list {com.yy.leetcode.linkedlist.merge_sort_top_down.png}.
 */

/**
 * https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
 */
public class SortList_incorrect {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //快慢指针法。当快指针到末端时慢指针到中间
        ListNode slow = head;
        ListNode fast = head.next;

        //判断fast.next 而不是fast。当fast到结尾时就可以结束了
        while (fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        //此时slow 已经指向中间了,下一步是把node分开，即断链。
        slow.next = null;
        //断链之后此时head 指向的链只有一半长度了，通过递归的方式直到head指向的链长度为一，即链被分成了最小单元
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        //now sort and merge two lists
        ListNode prehead = new ListNode(0);
        ListNode p = prehead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;

        }
        if (left != null) {
            p.next = left;
        }
        if (right != null) {
            p.next = right;
        }
        return prehead.next;

    }

}
