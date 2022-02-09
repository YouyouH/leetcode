////给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
////
//// L0 → L1 → … → Ln-1 → Ln 
////请将其重新排列后变为： 
////
//// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
////
//// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
////
//// 
////
//// 示例 1: 
////
//// 
////
//// 
////输入: head = [1,2,3,4]
////输出: [1,4,2,3] 
////
//// 示例 2: 
////
//// 
////
//// 
////输入: head = [1,2,3,4,5]
////输出: [1,5,2,4,3] 
////
//// 
////
//// 提示： 
////
//// 
//// 链表的长度范围为 [1, 5 * 10⁴] 
//// 1 <= node.val <= 1000 
//// 
////
//// 
////
//// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
//// Related Topics 栈 递归 链表 双指针 👍 30 👎 0
//


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-09 12:21:09
//重排链表

import com.yy.leetcode.linkedlist.LinkedListFactory;
import com.yy.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LGjMqU{
    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
        solution.reorderList(LinkedListFactory.createLinkedList(new int[]{1, 2, 3, 4, 5}));
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
    public void reorderList(ListNode head) {
        //先把节点放到array里面，然后双指针重新组合
        List<ListNode> array = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            array.add(p);
            p = p.next;
        }
        if (array.size() == 1) {
            return;
        }
        for (ListNode node : array) {
            //把链断开
            node.next = null;
        }

        int l = 0;
        int r = array.size() - 1;

        ListNode tmp = null;
        while (l <= r) {
            ListNode lNode = array.get(l);
            ListNode rNode = array.get(r);

            //左右指针相遇了说明到了中心点
            if (lNode == rNode) {
                tmp.next = lNode;
                break;
            }
            lNode.next = rNode;
            if (tmp != null) {
                tmp.next = lNode;
            }
            tmp = rNode;
            l++;
            r--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}