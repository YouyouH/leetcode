//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
//
// 
//
// 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 
// Related Topics 栈 链表 数学 👍 24 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-07 15:40:47
//链表中的两数相加

import com.yy.leetcode.linkedlist.LinkedListFactory;
import com.yy.leetcode.linkedlist.ListNode;

import java.util.LinkedList;

public class LMSNwu{
    public static void main(String[] args) {
         Solution solution = new LMSNwu().new Solution();
        ListNode l1 = LinkedListFactory.createLinkedList(new int[]{7, 2, 4, 3});
        ListNode l2 = LinkedListFactory.createLinkedList(new int[]{5, 6, 4});
        solution.addTwoNumbers(l1, l2);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //用两个链表把value存起来
        LinkedList<Integer> list1 = new LinkedList();
        LinkedList<Integer> list2 = new LinkedList();


        int maxLength = Math.max(extractValues(l1, list1), extractValues(l2, list2));

        //此时对两个链表同时相加，并把结果保存到一个LinkedList里面
        LinkedList<Integer> result = new LinkedList<>();
        int tmp = 0;
        for (int i = 0; i < maxLength; i++) {
            int a1 = 0;
            int a2 = 0;
            if (i < list1.size()) {
                a1 = list1.get(i);
            }
            if (i < list2.size()) {
                a2 = list2.get(i);
            }
            if (a1 + a2 + tmp > 9) {
                result.addLast(a1 + a2 + tmp - 10);
                tmp = 1;
            } else {
                result.addLast(a1 + a2 + tmp);
                tmp = 0;
            }
        }
        //最高位可能进1
        if (tmp > 0) {
            result.addLast(1);
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (int i = result.size() - 1; i >= 0; i--) {
            p.next = new ListNode(result.get(i));
            p = p.next;
        }
        return dummy.next;

    }

    private int extractValues(ListNode l1, LinkedList<Integer> list1) {
        int length = 0;
        while (l1 != null) {
            list1.addFirst(l1.val);
            l1 = l1.next;
            length++;
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}