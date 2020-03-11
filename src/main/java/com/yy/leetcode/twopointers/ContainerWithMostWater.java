package com.yy.leetcode.twopointers;

/**
 * @author youyouhuang
 * @create 2020-02-29
 * @desc
 **/

/**
 * https://leetcode.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 **/

/**
 * 双指针
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[0];
        int rightMax = height[right];

        int maxResults = 0;

        while (left < right) {

            if(height[left] < height[right]){
                maxResults = Math.max(height[left] * (right-left),maxResults);
                left++;
                leftMax = Math.max(leftMax,height[left]);
            }else{
                maxResults = Math.max(height[right] *(right - left),maxResults);
                right--;
                rightMax = Math.max(rightMax,height[right]);
            }

        }

        return maxResults;
    }

}
