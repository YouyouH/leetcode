package com.yy.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(0 == intervals.length){
            return new int[][]{newInterval};
        }

        int intervalCount = intervals.length;
        Map<Integer, Integer> leftPos2height = new HashMap<>();
        Map<Integer, Integer> rightPos2height = new HashMap<>();
        for (int i = 0; i < intervalCount; i++) {
            leftPos2height.put(i, intervals[i][0]);
            rightPos2height.put(i, intervals[i][1]);
        }

        int[] line = new int[Math.max(intervals[intervalCount - 1][1], newInterval[1]) + 1];
        for (int i = 0; i < line.length; i++) {
            line[i] = -1;
        }

        for (int i = 0; i < intervalCount; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                line[j] = i;
            }
        }

        int left = newInterval[0];
        int right = newInterval[1];

        if (line[left] != -1) {
            left = leftPos2height.get(line[left]);
        }
        if (line[right] != -1) {
            right = rightPos2height.get(line[right]);
        }

        //合并新的区间
        for (int i = left; i <= right ; i++) {
            line[i] = intervalCount + 1;
        }
        //重新遍历
        List<int[]> res = new ArrayList<>();

        int l = 0;
        int r = 0;
        for (int i = 0; i < line.length; i++) {
            int split = -1;
            while (r < line.length && line[l] == -1) {
                l++;
            }
            if (l == line.length) {
                break;
            }
            split = line[l];
            r = l;
            while (r < line.length && line[r] == split) {
                r++;
            }
            res.add(new int[]{l,r-1});
            l = r;
        }
        return res.toArray(new int[][]{});
    }
}
