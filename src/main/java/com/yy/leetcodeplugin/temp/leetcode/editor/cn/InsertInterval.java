
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-03 14:09:48 
//插入区间

import java.util.ArrayList;
import java.util.List;

public class InsertInterval{
    public static void main(String[] args) {
         Solution solution = new InsertInterval().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /**
         * FIXME 看的答案
         *  遍历区间，判断新区间和当前区间的位置关系
         */
        List<int[]> ans = new ArrayList<>();
        int len = intervals.length;


        int left = newInterval[0];
        int right = newInterval[1];

        boolean merged = false;
        for (int i = 0; i < len; i++) {
            int[] cur = intervals[i];
            //当前区间在新区间的左边，直接把当前区间加入答案
            if (cur[1] < left) {
                ans.add(cur);
            } else if (cur[0] > right) {//当前区间在新区间右边。注意这里的新区间可能是merge过的，right是merge过的值
                if(!merged) {
                    //此时merge已经结束了，所以可以把merge的区间加进去
                    ans.add(new int[]{left, right});
                    merged = true;
                }
                ans.add(cur);
            }else{
                //有交集，计算merge过的端点值.但是此时还不确定加入答案中，因为后面可能还要merge
                left = Math.min(left, cur[0]);
                right = Math.max(right, cur[1]);
            }
        }
        if (!merged) {//有可能merge 的区间是最后一个导致上面的循环没有把merge 区间加入答案
            ans.add(new int[]{left, right});
        }


        return ans.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区
//间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的
//开始和结束。 
//
// 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，
//可以合并区间）。 
//
// 返回插入之后的 intervals。 
//
// 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals 根据 starti 按 升序 排列 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// Related Topics 数组 👍 976 👎 0
