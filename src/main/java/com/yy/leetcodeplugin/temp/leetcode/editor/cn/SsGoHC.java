  //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
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
// 
//
// 注意：本题与主站 56 题相同： https://leetcode-cn.com/problems/merge-intervals/ 
// Related Topics 数组 排序 👍 15 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-09 15:21:33 
//合并区间

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.Comparator;
  import java.util.List;

  public class SsGoHC{
    public static void main(String[] args) {

        Solution solution = new SsGoHC().new Solution();
//        solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        solution.merge(new int[][]{{1, 4}, {4, 5}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        //(看的答案)按左端点排序，再遍历右端点
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();

        int l=0;
        int r=0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                l = intervals[i][0];
                r = intervals[i][1];
            } else {
                //如果左边在上一个区间内，那么更新右边最大值即可
                if (intervals[i][0] >= l && intervals[i][0] <= r) {
                    r = Math.max(r,intervals[i][1]);
                } else {
                    //当前区间和前一个没有重合，则把上一个加进来
                    res.add(new int[]{l, r});
                    //更新l r
                    l = intervals[i][0];
                    r = intervals[i][1];
                }
            }
            if (i == intervals.length - 1) {
                res.add(new int[]{l, r});
            }
        }

        return res.toArray(new int[][]{});
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}