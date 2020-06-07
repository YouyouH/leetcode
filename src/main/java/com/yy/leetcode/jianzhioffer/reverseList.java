package com.yy.leetcode.jianzhioffer;
/**
 * @author youyouhuang
 * @create 2020-06-07
 **/

import com.yy.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *<p>
 *
 *</p>
 **/
public class reverseList {
    public int[] reversePrint(ListNode head) {
        //链表反转
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        List<Integer> list = new ArrayList();
        while(pre!=null){
            list.add(pre.val);
            pre = pre.next;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}
