package com.yy.leetcode.unclear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * intervals[i][0] <= intervals[i][1]
 * @author huangyou
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            for (int num : interval) {
                if(num > max){
                    max = num;
                }
            }
        }

        int[] array = new int[max+1];

        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j <=intervals[i][1] ; j++) {
                array[j] = 1;
            }
        }

        List<int[]> result = new ArrayList<>();
        int start = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0 && -1 == start){
                start = i;
            }
            if(-1 != start) {
                if (array[i] == 0) {
                    result.add(new int[]{start, i - 1});
                    start = -1;
                }else if(i == array.length-1){
                    result.add(new int[]{start, i});
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}
