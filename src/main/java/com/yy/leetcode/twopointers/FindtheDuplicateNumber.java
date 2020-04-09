package com.yy.leetcode.twopointers;
/**
 * @author youyouhuang
 * @create 2020-04-09
 **/

/**
 *给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 示例 1:  输入: [1,3,4,2,2] 输出: 2
 *
 *<p>
 *
 *</p>
 *<p>说明：
 *<p>    不能更改原数组（假设数组是只读的）。
 *<p>    只能使用额外的 O(1) 的空间。
 *<p>    时间复杂度小于 O(n2) 。
 *<p>    数组中只有一个重复的数字，但它可能不止重复出现一次。
 *<p>来源：力扣（LeetCode）
 *<p>链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 *<p>著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindtheDuplicateNumber {
    int dup = 0;
    public int findDuplicate(int[] nums) {
        //快排修改了原始输入，不符合题目要求
        //quick three way sort 修改一下
        quickSort(nums,0,nums.length-1);
        return dup;
//        int pre = 0;
//        for (int num : nums) {
//            if(num == pre){
//                return num;
//            }
//            pre = num;
//        }
//        return 0;
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if(lo >= hi ||dup != 0){
            return;
        }
        int l = lo;
        int h = hi;
        int i = lo+1;
        int pivot = nums[l];

         while(i<=h){
            if(nums[i] > pivot){
                exch(nums,i,h--);
            }else if(nums[i]<pivot){
                exch(nums,i++,l++);
            }else{
                i++;
                dup = pivot;
            }
        }
        quickSort(nums,lo,l-1);
        quickSort(nums,h+1,hi);
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
