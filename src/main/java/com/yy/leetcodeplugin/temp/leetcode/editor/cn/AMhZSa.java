//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 23 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-10 20:56:47
//回文链表

import com.yy.leetcode.linkedlist.ListNode;

import java.util.LinkedList;

public class AMhZSa{
    public static void main(String[] args) {
         Solution solution = new AMhZSa().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList();
        ListNode p = head;
        while (p != null) {
            linkedList.addLast(p.val);
            p = p.next;
        }
        Integer[] array = linkedList.toArray(new Integer[0]);
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] == array[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}