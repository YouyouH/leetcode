
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-25 13:58:53 
//H 指数 II

public class HIndexIi{
    public static void main(String[] args) {
         Solution solution = new HIndexIi().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        /**
         * 二分法求最大值
         */
        int len = citations.length;

        int l = 0;
        int r = len - 1;
        int ans = len;
        //用的是索引，不是第几篇文章，最后的答案要加一
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] >= len-mid) {//引用数量 和 大于当前引用数量的论文数量做比较
                ans = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return len - ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计
//算并返回该研究者的 h 指数。 
//
// h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）至少 有 h 篇论文分别被
//引用了至少 h 次。 
//
// 请你设计并实现对数时间复杂度的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：citations = [0,1,3,5,6]
//输出：3
//解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
//     由于研究者有3篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3 。 
//
// 示例 2： 
//
// 
//输入：citations = [1,2,100]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n == citations.length 
// 1 <= n <= 10⁵ 
// 0 <= citations[i] <= 1000 
// citations 按 升序排列 
// 
//
// Related Topics 数组 二分查找 👍 366 👎 0
