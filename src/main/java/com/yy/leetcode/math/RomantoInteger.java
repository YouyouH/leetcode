package com.yy.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youyouhuang
 * @create 2019-09-04
 * @desc
 **/

public class RomantoInteger {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        iniMap(map);
        Integer[] nums = new Integer[s.length()];
        for(int i=0; i<s.length();i++){
            nums[i] = map.get(s.substring(i,i+1));
        }
        int result = nums[nums.length-1];
        int tmp = nums[nums.length-1];
        for(int j=nums.length-1; j>=1; j--){
            if(nums[j-1]<tmp){
                result -= nums[j-1];
            }else{
                tmp = nums[j-1];
                result += nums[j-1];
            }
        }
        return  result;
    }

    private void iniMap(Map<String, Integer> map) {
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
    }
}
