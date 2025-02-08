
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-08 17:27:19 
//找出临界点之间的最小和最大距离

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints{
    public static void main(String[] args) {
         Solution solution = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints().new Solution();
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;

        ListNode cp = null;//极值点

        int min = Integer.MAX_VALUE;
        int max = 0;
        int distance = 0;//相邻距离

        while (null != p2.next) {
            int preVal = p1.val;
            int curVal = p2.val;
            int nextVal = p2.next.val;

            if ((preVal > curVal && nextVal > curVal) || (preVal < curVal && nextVal < curVal)) {
                //找到了极值点
                if (null != cp) {//前面已经有一个极值点才能计算两个极值点的距离
                    min = Math.min(min, distance);//最小值就是相邻点的距离的最小值
                    max += distance;//最大值就是所有的距离加起来
                }
                distance = 0;//重新统计距离
                cp = p2;//指向新的极点
            }
            distance++;
            p1 = p1.next;
            p2 = p2.next;
        }
        return min == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{min, max};

        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。 
//
// 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个 局部极大值点 。 
//
// 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个 局部极小值点 。 
//
// 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。 
//
// 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同
//临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,1]
//输出：[-1,-1]
//解释：链表 [3,1] 中不存在临界点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [5,3,1,2,5,1,2]
//输出：[1,3]
//解释：存在三个临界点：
//- [5,3,1,2,5,1,2]：第三个节点是一个局部极小值点，因为 1 比 3 和 2 小。
//- [5,3,1,2,5,1,2]：第五个节点是一个局部极大值点，因为 5 比 2 和 1 大。
//- [5,3,1,2,5,1,2]：第六个节点是一个局部极小值点，因为 1 比 5 和 2 小。
//第五个节点和第六个节点之间距离最小。minDistance = 6 - 5 = 1 。
//第三个节点和第六个节点之间距离最大。maxDistance = 6 - 3 = 3 。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1,3,2,2,3,2,2,2,7]
//输出：[3,3]
//解释：存在两个临界点：
//- [1,3,2,2,3,2,2,2,7]：第二个节点是一个局部极大值点，因为 3 比 1 和 2 大。
//- [1,3,2,2,3,2,2,2,7]：第五个节点是一个局部极大值点，因为 3 比 2 和 2 大。
//最小和最大距离都存在于第二个节点和第五个节点之间。
//因此，minDistance 和 maxDistance 是 5 - 2 = 3 。
//注意，最后一个节点不算一个局部极大值点，因为它之后就没有节点了。
// 
//
// 示例 4： 
//
// 
//
// 
//输入：head = [2,3,3,2]
//输出：[-1,-1]
//解释：链表 [2,3,3,2] 中不存在临界点。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数量在范围 [2, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 
//
// Related Topics 链表 👍 28 👎 0
