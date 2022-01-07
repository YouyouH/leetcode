  //给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
//
// 
//
// 注意：本题与主站 713 题相同：https://leetcode-cn.com/problems/subarray-product-less-than-
//k/ 
// Related Topics 数组 滑动窗口 👍 32 👎 0

  
package com.yy.leetcodeplugin.leetcode.editor.cn;

//2022-01-07 11:05:32 
//乘积小于 K 的子数组

public class ZVAVXX{
    public static void main(String[] args) {
         Solution solution = new ZVAVXX().new Solution();
        solution.numSubarrayProductLessThanK(new int[]{10,5,2,6},100);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //滑动窗口，left表示左边，right表示右边
        //右边先移动，超出k之后再移动左边
        int res = 0;
        int left = 0;

        int max = 1;
        for (int right = 0; right < nums.length; right++) {
            while (right < nums.length && (max *= nums[right]) < k) {
                System.out.println(left+","+right);
                //当max小于k时，不断通过右移扩大窗口大小，直到超过k或者达到边界
                right++;
                res++;

            }

            if (left < nums.length && left <= right) {
                left++;
                //移动左边界缩小窗口
                if((max /= nums[left-1]) < k){
                    res++;
                    System.out.println(left+","+right);
                }

            }
        }
        return res;



//        太慢了！！！滑动窗口实现不对
//        //滑动窗口，i表示起点，j表示窗口大小。
//        //i不变，扩大窗口大小直到超过k,然后移动i,窗口初始化为0，继续这个过程
//
//        int res = 0;
//        if (k < 0 ) {
//            return 0;
//        }
//
//        //太慢了！！！滑动窗口实现不对
//        for (int i = 0; i < nums.length; i++) {
//            int max = 1;
//            for (int j = 1; j <= nums.length - i; j++) {
//                if ((max *= nums[i + j - 1]) < k) {
//                    res++;
//                }else {
//                    //都是正整数，所以一旦超过后面的就不用考虑了
//                    break;
//                }
//            }
//        }
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}