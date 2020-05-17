package com.yy.leetcode.jianzhioffer;
/**
 * @author youyouhuang
 * @create 2020-05-17
 **/

/**
 *一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *<p>
 *
 *</p>
 **/
public class Shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_lcof {
    public int[] singleNumbers(int[] nums) {
        //遍历一遍找出最大值
        //用一个数组的index表示valuevalue
        //遍历一遍找出出现了两次的值
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max,num);
        }
        int[] bit = new int[max+1];
        for (int num : nums) {
            bit[num] ++;
        }
        int[] result = new int[2];
        int j = 0;
        for (int i = 0; i < bit.length; i++) {
            if(bit[i] == 1){
                result[j] = i;
                j++;
            }
        }
        return result;
    }
}
