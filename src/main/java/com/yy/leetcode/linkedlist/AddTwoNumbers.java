package com.yy.leetcode.linkedlist;

/**
 * @author youyouhuang
 * @create 2020-02-29
 * @desc https://leetcode.com/problems/add-two-numbers/
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


/**
 *https://leetcode.com/problems/add-two-numbers/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        int tmp = 0;
        ListNode listNode = new ListNode(0);
        ListNode pNode = listNode;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if(sum + tmp >=10){
                pNode.next = new ListNode(sum + tmp -10);
                tmp = 1;
            }else{
                pNode.next = new ListNode(sum + tmp);
                tmp = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            pNode = pNode.next;
        }
        if(l1 == null && l2 == null){
            if(tmp>0){
                pNode.next = new ListNode(tmp);
            }
            return listNode.next;
        }
        append(l1, l2, tmp, pNode);
        append(l2, l1, tmp, pNode);

        return listNode.next;
    }

    private void append(ListNode l1, ListNode l2, int tmp, ListNode pNode) {
        if(l1==null){
            while(l2 != null){
                int sum = l2.val + tmp;
                if(sum >=10){
                    pNode.next = new ListNode(sum-10);
                    tmp = 1;
                }else{
                    pNode.next = new ListNode(sum);
                    tmp = 0;
                }
                l2 = l2.next;
                pNode = pNode.next;
            }
            if(tmp>0){
                pNode.next = new ListNode(tmp);
            }
        }
    }

}