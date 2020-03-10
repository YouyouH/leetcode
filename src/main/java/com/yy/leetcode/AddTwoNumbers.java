package com.yy.leetcode;

/**
 * @author youyouhuang
 * @create 2020-02-29
 * @desc
 **/

import java.util.LinkedList;

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
 * 不能转换成int/long, node 可能非常多。应该按位计算
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 || null == l1) {

        }
        return null;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if(null==l1 || null == l1){
//            return null;
//        }
//
//        long number1 = convertToInt(l1);
//        long number2 = convertToInt(l2);
//
//        long resultNumber = number1 + number2;
//
//        String resultString = String.valueOf(resultNumber);
//        int length = resultString.length();
//
//        LinkedList<ListNode> resultList = new LinkedList<>();
//
//        for (int i = length-1; i > -1; i--) {
//            int v = (int) (resultNumber / Math.pow(10, i));
//            resultNumber = (long) (resultNumber % Math.pow(10, i));
//            resultList.add(new ListNode(v));
//        }
//
//        ListNode resultNode = new ListNode(resultList.get(resultList.size()-1).val);
//
//        ListNode next = resultNode;
//
//        for(int i = length-2; i>-1;i--){
//            next.next = resultList.get(i);
//            next = next.next;
//        }
//
//        return resultNode;
//
//    }
//
//    private long convertToInt(ListNode l1) {
//        long result = 0;
//        result = result + l1.val;
//        for(int i=1; l1.next !=null ;i++){
//            result = result + ((long) (l1.next.val * (Math.pow(10, i))));
//            l1 = l1.next;
//        }
//        return result;
//    }

}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}