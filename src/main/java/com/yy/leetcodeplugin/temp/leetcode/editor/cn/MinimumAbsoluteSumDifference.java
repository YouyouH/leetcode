
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-24 14:44:52 
//绝对差值和

import jdk.javadoc.internal.tool.Start;

import java.util.Arrays;

public class MinimumAbsoluteSumDifference{
    public static void main(String[] args) {
         Solution solution = new MinimumAbsoluteSumDifference().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private static final int MOD = 1_000_000_000 + 7;
            public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
                /**
                 * 求出差值数组，然后对于每个i,二分查找nums1中最接近nums2[i]的数，并记录减小的差值大小。
                 *      需要对nums1排序方便进行二分操作
                 *
                 * 优化？对差值数组再排序。如果减小的差值大于nums2的值，那就可以结束了，因为肯定不可能更优化了。
                 */
                int length = nums1.length;
                int[] diff = new int[length];

                int diffSum = 0;//记录所有差值的和

                int max = 0;//记录减小差值的最大值

                for (int i = 0; i < length; i++) {
                    diff[i] = Math.abs(nums1[i] - nums2[i]);
                    diffSum = (diffSum + diff[i]) % MOD;
                }

                if (diffSum == 0) {
                    return 0;
                }

                int[] clone1 = nums1.clone();
                Arrays.sort(clone1);

                for (int i = 0; i < length; i++) {
                    int val = binSearch(nums2[i], clone1);//得到最接近nums2[i]的值
//                    System.out.println("i=" + i + " val=" + val);
                    max = Math.max(max, diff[i] - Math.abs(val - nums2[i]));
                }

                return (diffSum - max+MOD)%MOD;//FIXME： 这里diffSum取模之后可能跟max相减得到负数，所以要再加上模

            }

            /**
             * 找到最接近target的数，可能大于也可能小于
             *
             * 这里现找出大于等于target的索引j，然后判断j 和 j-1谁更接近target
             *
             */
            private int binSearch(int target, int[] nums) {
                int l = 0;
                int r = nums.length - 1;
                int left = r; //要确定左边界 //FIXME:左边界不能是0，要是最大值，即最右边
                while (l <= r) {
                    int mid = l + (r - l) / 2;
//                    System.out.println("l=" + l + " r=" + r + " mid=" + mid + " nums[mid]=" + nums[mid]);
                    if (nums[mid] >= target) {
                        left = mid;
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
//                System.out.println("target=" + target + " left=" + left);
                if (left == 0) {//索引等于0就是最接近的值
                    return nums[left];
                }
                //此时left是左边界,nums[left]>= target, nums[left-1] < target
                return Math.abs(nums[left] - target) <= Math.abs(nums[left - 1] - target) ? nums[left] : nums[left - 1];

            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。 
//
// 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始
//）。 
//
// 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。 
//
// 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 10⁹ + 7 取余 后返回。 
//
// |x| 定义为： 
//
// 
// 如果 x >= 0 ，值为 x ，或者 
// 如果 x <= 0 ，值为 -x 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,7,5], nums2 = [2,3,5]
//输出：3
//解释：有两种可能的最优方案：
//- 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
//- 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
//两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
//输出：0
//解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
//输出：20
//解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
//绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// 1 <= n <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 10⁵ 
// 
//
// Related Topics 数组 二分查找 有序集合 排序 👍 179 👎 0
