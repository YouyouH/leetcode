//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
// Related Topics 数组 数学 字符串 排序 👍 8 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-09 18:14:17
//最小时间差

import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Five69nqc{
    public static void main(String[] args) {
         Solution solution = new Five69nqc().new Solution();
        solution.findMinDifference(Arrays.asList("00:00", "04:00", "22:00"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        //把时间转换成分钟然后排序，小时乘以60+分钟.注意 00：00要考虑前后的时间差
        List<Integer> mins = timePoints.stream().map(this::convertToMins).sorted().collect(Collectors.toList());
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < mins.size(); i++) {
            int diff = mins.get(i) - mins.get(i - 1);
            int resolvedDiff = Math.min(Math.abs(diff - 24 * 60), diff);
            minDiff = Math.min(minDiff, resolvedDiff);
        }

        //再比较00：00 和 23：59这种情况
        int diff = mins.get(mins.size()-1) - mins.get(0);
        int resolvedDiff = Math.min(Math.abs(diff - 24 * 60), diff);
        minDiff = Math.min(minDiff, resolvedDiff);

        return minDiff;
    }

        private int convertToMins(String s) {
            return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}