
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-25 10:29:43 
//爱吃香蕉的珂珂

import java.util.Arrays;

public class KokoEatingBananas{
    public static void main(String[] args) {
         Solution solution = new KokoEatingBananas().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int minEatingSpeed(int[] piles, int h) {
                /**
                 * 二分法找K
                 */
                int l = 1;//速度最小值
                int r = Arrays.stream(piles).max().getAsInt();//速度最大值
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (check(piles, mid) <= h) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                return l;
            }

            private long check(int[] piles, int speed) {
                long sum = 0;
                for (int pile : piles) {
//                    sum += pile / speed;
//                    if (pile % speed != 0) {
//                        sum += 1;
//                    }
                    //FIXME:  这一行优化会快很多，或者用向上取整 Math.ceil()
                    sum += (pile + speed - 1) / speed;


                }
//                System.out.println("speed=" + speed + " sum=" + sum);
                return sum;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。 
//
// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：piles = [3,6,7,11], h = 8
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：piles = [30,11,23,4,20], h = 5
//输出：30
// 
//
// 示例 3： 
//
// 
//输入：piles = [30,11,23,4,20], h = 6
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 676 👎 0
