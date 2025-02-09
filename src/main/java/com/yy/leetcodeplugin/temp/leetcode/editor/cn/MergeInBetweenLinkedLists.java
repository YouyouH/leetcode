
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-08 23:40:14 
//合并两个链表

public class MergeInBetweenLinkedLists{
    public static void main(String[] args) {
         Solution solution = new MergeInBetweenLinkedLists().new Solution();
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        /**
         * 遍历到第 a-1+1个点的时候开始断开，再接上第b+1个点
         *
         * FIXME：
         *  方案还能优化。指针不需要都移动，只要指向几个关键的点就行，再串起来
         */
        ListNode cur = list1;

        ListNode p1 = list1;
        int distance = 0;//标记走过的距离

        while (cur != null) {
            distance++;
            if (distance == a) {
                //遇到第一个断开的点
                cur = cur.next;//先把当前指针移动到remove区域,下面才能接上list2
                p1.next = list2;//接上list2
            } else if (distance == b + 2) {
                //到达第二个点，先把p1移到最后
                while (p1.next != null) {
                    p1 = p1.next;//移动到list2尾巴，准备接上剩下的部分
                }
                //遇到第二个断开的点
                p1.next = cur;
//                cur = cur.next;//续上了就不需要再管cur
            } else{
                cur = cur.next;
                if(p1.next!=null) {//FIXME 这里要确保p1不是null
                    p1 = p1.next;
                }
            }
        }
        return list1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。 
//
// 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。 
//
// 下图中蓝色边和节点展示了操作后的结果： 
// 
// 请你返回结果链表的头指针。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
//输出：[10,1,13,1000000,1000001,1000002,5]
//解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
// 
//
// 示例 2： 
// 
// 
//输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,100
//0003,1000004]
//输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
//解释：上图中蓝色的边和节点为答案链表。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= list1.length <= 10⁴ 
// 1 <= a <= b < list1.length - 1 
// 1 <= list2.length <= 10⁴ 
// 
//
// Related Topics 链表 👍 120 👎 0
