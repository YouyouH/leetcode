package com.yy.leetcode.linkedlist;
/**
 * @author youyouhuang
 * @create 2020-04-14
 **/

import java.util.List;

/**
 *给定一个链表，判断链表中是否有环。  为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *<p>
 *
 *</p>
 **/
public class LinkedListCycle {
    //快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        boolean result = false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != null && fast != null) {
            if(slow == fast){
                result = true;
                break;
            }
            slow = slow.next;
            if(fast.next == null){
                break;
            }
            fast = fast.next.next;
        }
        return result;
    }
}
