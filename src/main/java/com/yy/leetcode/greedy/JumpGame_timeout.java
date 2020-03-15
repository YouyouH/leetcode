package com.yy.leetcode.greedy;

/**
 * @author youyouhuang
 * @create 2020-03-14
 * @desc
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * Example:
 * [2,3,1,1,4]
 * [1,0,0,0]
 */

/**
 * 技巧：
 * 这种判断true/false 的递归函数可以直接用if(method)来递归，这样一旦发现某次为true就直接返回
 *
 * 这种接法在数组太大时会timeout
 */
public class JumpGame_timeout {

    public boolean canJump(int[] nums) {
        if(nums == null ||nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return true;
        }
        //递归输入:nums, start,nums.length
        //递归输出:true
        Map<Integer,Boolean> memo = new HashMap<>();

        return jump(nums, 0, nums.length,memo);
    }

    private boolean jump(int[] nums, int start, int length, Map<Integer,Boolean> memo) {
        if(start >= length){
//            memo.put(start,false);
            return false;
        }
        int max = start + nums[start];

        if(max >= length-1){
            return true;
        }
        for (int i = start + 1; i < max + 1; i++) {
            if(memo.containsKey(i) && memo.get(i) == false){
                continue;
            }
            if(jump(nums, i, length, memo)){
                return true;
            }
        }
        if(null == memo.get(start)){
            memo.put(start,false);
        }
        return false;
    }

}
