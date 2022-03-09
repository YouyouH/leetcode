  //狒狒喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。 
//
// 狒狒可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。 
//
// 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入: piles = [3,6,7,11], H = 8
//输出: 4
// 
//
// 示例 2： 
//
// 
//输入: piles = [30,11,23,4,20], H = 5
//输出: 30
// 
//
// 示例 3： 
//
// 
//输入: piles = [30,11,23,4,20], H = 6
//输出: 23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10^4 
// piles.length <= H <= 10^9 
// 1 <= piles[i] <= 10^9 
// 
//
// 
//
// 注意：本题与主站 875 题相同： https://leetcode-cn.com/problems/koko-eating-bananas/ 
// Related Topics 数组 二分查找 👍 18 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-08 11:00:09 
//狒狒吃香蕉

public class NZZqjQ{
    public static void main(String[] args) {

        Solution solution = new NZZqjQ().new Solution();
        solution.minEatingSpeed(new int[]{3,6,7,11}, 8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //https://labuladong.github.io/algo/2/22/61/
        public int minEatingSpeed(int[] piles, int h) {
            //思路:先思考怎么计算吃完所有香蕉的用时
//        for (int pile : piles) {
//            sum += Math.ceil(pile/K)
//        }
//        要满足sum <= H
//        由于题目要求了，即使香蕉少于K，也只能吃完之后等下一个小时，所以吃香蕉的速度最大是Max(pile[i]),
//        再快也没意义了。速度取值范围 1-Max(pile[i])
            int hi = 0;
            for (int i = 0; i < piles.length; i++) {
                hi = Math.max(hi, piles[i]);
            }
            int lo = 1;

            //循环退出条件： lo = hi
            while (lo < hi) {
                int mid = (hi + lo) / 2;
                int sum = 0;
                for (int i = 0; i < piles.length; i++) {
                    sum += Math.ceil((double) piles[i] / mid);
                }
                if (sum <= h) {
                    hi = mid;
                    /**为什么不用mid-1?
                     * 假如左边没有再符合条件的了，即sum都大于h,那么最后退出循环时，lo=hi，hi就是边界值
                     * 加入左边还有符合条件的，则继续缩小边界，相当于重新进入上一个逻辑里面。
                     */
                } else {
                    lo = mid + 1;
                }
            }
            //退出循环时lo=hi,所以返回lo/hi都可以
            return lo;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}