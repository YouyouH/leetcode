
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-08 14:48:18 
//接雨水

public class TrappingRainWater{
    public static void main(String[] args) {
         Solution solution = new TrappingRainWater().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        /**
         * FIXME：
         *  这道题是求雨水面积，不要想着一次求一片雨水的面积，要从每一根柱子能够接的雨水思考
         *      对于每一根柱子，能够接的水等于柱子左右两边的最高值中的较低值，减去柱子自己的高度。
         *          此时问题就转化为枚举每一根柱子，求每一根柱子左右两边的最高值。
         *              可以用DP先存起来，不用枚举的时候再遍历
         *  FIXME: 上面的方案答案是对的，但是时间复杂度太高了.不需要用DP去求
         */

//        //先用dp求对于每一根柱子的左边的最大值
//        int n = height.length;
//        int[] dpl = new int[n];
//        for (int i = 0; i < n; i++) {
//            dpl[i] = 0;
//            for (int j = 0; j < i; j++) {
//                dpl[i] = Math.max(dpl[i], height[j]);
//            }
//        }
//
//        //先用dp求对于每一根柱子的右边的最大值
//        int[] dpr = new int[n];
//        for (int i = n - 1; i >= 0; i--) {
//            dpr[i] = 0;
//            for (int j = n - 1; j > i; j--) {
//                dpr[i] = Math.max(dpr[i], height[j]);
//            }
//        }
//
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            int min = Math.min(dpl[i], dpr[i]);
//            if (min > height[i]) {
//                ans += min - height[i];
//            }
////            System.out.println("i=" + i + " val=" + (min) + " height" + height[i]);
//        }
//
//        return ans;



        //先用dp求对于每一根柱子的左边的最大值
        int n = height.length;
        int maxl = 0;
        int[] dpl = new int[n];
        dpl[0] = 0;
        for (int i = 1; i < n; i++) {
            maxl = Math.max(maxl, height[i-1]);
            dpl[i] = maxl;
//            System.out.println("i=" + i + " val=" + dpl[i]);
        }

//        System.out.println("****");

        //先用dp求对于每一根柱子的右边的最大值
        int[] dpr = new int[n];
        dpr[n - 1] = 0;
        int maxr = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxr = Math.max(maxr, height[i+1]);
            dpr[i] = maxr;
//            System.out.println("i=" + i + " val=" + dpr[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(dpl[i], dpr[i]);
            if (min > height[i]) {
                ans += min - height[i];
            }
//            System.out.println("i=" + i + " val=" + (min) + " height" + height[i]);
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5501 👎 0
