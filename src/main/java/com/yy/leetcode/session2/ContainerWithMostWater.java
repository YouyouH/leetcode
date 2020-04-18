package com.yy.leetcode.session2;
/**
 * @author youyouhuang
 * @create 2020-04-18
 **/

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * <p>
 *
 * </p>
 **/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null){
            return 0;
        }
        int max = 0;

        int lo = 0;
        int hi = height.length - 1;

        while (lo <= hi) {
            if (height[lo] <= height[hi]) {
                max = Math.max(max, (hi - lo) * height[lo]);
                lo++;
            }else{
                max = Math.max(max, (hi - lo) * height[hi]);
                hi--;
            }
        }
        return max;
    }
}
