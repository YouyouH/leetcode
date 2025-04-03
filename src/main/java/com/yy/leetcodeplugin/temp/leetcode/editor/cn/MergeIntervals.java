
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-03 11:06:10 
//合并区间

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals{
    public static void main(String[] args) {
         Solution solution = new MergeIntervals().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        /**
         * 方法一：排序然后遍历一遍
         */
        //先按起点排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int len = intervals.length;//有多少段区间
        List<int[]> ans = new ArrayList<>();

        int[] pre = intervals[0];
        if (len == 1) {
            ans.add(pre);
        }
        for (int i = 1; i < len; i++) {
            int[] cur = intervals[i];
            if (cur[0] <= pre[1]) {//当前区间的起点小于上一个区间的终点，说明有重合
                pre[1] = Math.max(pre[1], cur[1]);//扩展前一个区间
                if (i == len - 1) {//如果是最后一个区间就直接加入答案
                    ans.add(pre);
                }
            }else{
                //当前区间跟前一个区间没有重合
                ans.add(pre);//把上一个区间放入答案中
                pre = cur;
                if (i == len - 1) {//如果是最后一个区间就直接加入答案
                    ans.add(cur);
                }
            }
        }
        return ans.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2546 👎 0
