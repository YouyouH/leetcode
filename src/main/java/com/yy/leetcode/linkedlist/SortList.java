package com.yy.leetcode.linkedlist;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 *     你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList {
    /**
     * 归并排序，先拆成最小部分然后排序
     * 每次递归都把array分成左右两部分，参数是起始点和结尾两个坐标
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head, null);
    }

    private ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        //断开左右链表
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode l1 = mergeSort(head, mid);
        ListNode l2 = mergeSort(mid, tail);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode dhead = dummyNode, head1 = l1, head2 = l2;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                dhead.next = head1;
                head1 = head1.next;
            } else {
                dhead.next = head2;
                head2 = head2.next;
            }
            dhead = dhead.next;
        }
        if (head1 != null) {
            dhead.next = head1;
        } else {
            dhead.next = head2;
        }
        return dummyNode.next;
    }
}
