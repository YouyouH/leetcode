package com.yy.quicksort;

/**
 * @author youyouhuang
 * @create 2020-03-28
 * @desc https://leetcode.com/problems/sort-colors/
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 **/

public class SortColors {

    public void sortColors(int[] nums) {
        //快速排序是原地排序。但是大量重复元素会导致复杂度退化到n^2
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int p = partion(nums, start, end);
        quickSort(nums, 0, p - 1);
        quickSort(nums, p + 1, end);
    }

    private int partion(int[] nums, int start, int end) {
        int p = nums[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && nums[j] > p) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < p) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = p;
        return i;
    }

}
