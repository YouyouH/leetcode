package com.yy.leetcode.linkedlist;

/**
 * @author youyouhuang
 * @create 2020-03-15
 * @desc
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }
}
