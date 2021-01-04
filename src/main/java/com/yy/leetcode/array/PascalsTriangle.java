package com.yy.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for (int i = 2; i <= numRows ; i++) {
            List<Integer> level = new ArrayList<>(i);
            level.add(1);
            for (int j = 1; j < i-1 ; j++) {
                level.add(j, res.get(i-2).get(j-1) + res.get(i-2).get(j));
            }
            level.add(1);
            res.add(level);
        }
        return res;
    }
}
