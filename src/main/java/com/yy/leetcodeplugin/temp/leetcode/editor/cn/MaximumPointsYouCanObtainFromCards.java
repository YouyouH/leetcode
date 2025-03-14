
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-14 10:29:56 
//可获得的最大点数

import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards{
    public static void main(String[] args) {
         Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        /**
         * 把拿K张转化为剩下的 length-k 不拿。转化为定长窗口问题
         */
        int length = cardPoints.length;
        int size = length - k;
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        int total = 0;

        if (size == 0) {
            return Arrays.stream(cardPoints).sum();
        }

        for (r = 0; r < size; r++) {//FIXME: 这里要注意结束循环之后，r已经指向下一个了
            sum += cardPoints[r];
        }
        total = sum;
        r--;
        min = Math.min(min, sum);

        while (r+1 < length) {
            sum -= cardPoints[l];
            l++;
            r++;
            sum += cardPoints[r];
            total += cardPoints[r];
            min = Math.min(min, sum);
        }

        return total - min;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。 
//
// 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。 
//
// 你的点数就是你拿到手中的所有卡牌的点数之和。 
//
// 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
//输出：12
//解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5
// = 12 。
// 
//
// 示例 2： 
//
// 输入：cardPoints = [2,2,2], k = 2
//输出：4
//解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
// 
//
// 示例 3： 
//
// 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
//输出：55
//解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
// 
//
// 示例 4： 
//
// 输入：cardPoints = [1,1000,1], k = 1
//输出：1
//解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。 
// 
//
// 示例 5： 
//
// 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
//输出：202
// 
//
// 
//
// 提示： 
//
// 
// 1 <= cardPoints.length <= 10^5 
// 1 <= cardPoints[i] <= 10^4 
// 1 <= k <= cardPoints.length 
// 
//
// Related Topics 数组 前缀和 滑动窗口 👍 439 👎 0
