package com.yy.leetcode.linkedlist;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionList {
    /**
     * 1.先构造两个list,最后连起来
     *
     */
    public ListNode partition(ListNode head, int x) {
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        ListNode p2h = p2;
        ListNode res = p1;
        while (head != null){
            if(head.val >=x){
                p2.next = new ListNode(head.val);
                p2 = p2.next;
            }else{
                p1.next = new ListNode(head.val);
                p1 = p1.next;
            }
            head = head.next;
        }
        //跳过p2的第一个哨兵节点
        p1.next = p2h.next;

        return res.next;
    }
}
