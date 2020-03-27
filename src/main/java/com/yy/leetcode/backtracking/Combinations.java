package com.yy.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-03-27
 * @desc https://leetcode-cn.com/problems/combinations/
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 **/

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if(n<0){
            return results;
        }
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i+1;
        }

        traverse(numbers,results,new ArrayList<Integer>(),0,0,k);
        return results;
    }

    private void traverse(int[] numbers, List<List<Integer>> results, ArrayList<Integer> cur, int start, int depth, int maxDepth) {
        if(depth == maxDepth){
            results.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            cur.add(numbers[i]);
            depth++;
            traverse(numbers,results,cur,i+1,depth,maxDepth);
            cur.remove(cur.size()-1);
            depth--;
        }
    }
}
