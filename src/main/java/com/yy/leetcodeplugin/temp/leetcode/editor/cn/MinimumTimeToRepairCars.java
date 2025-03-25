
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-25 09:34:40 
//修车的最少时间

import java.util.Arrays;
import java.util.OptionalInt;

public class MinimumTimeToRepairCars{
    public static void main(String[] args) {
         Solution solution = new MinimumTimeToRepairCars().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public long repairCars(int[] ranks, int cars) {
                /**
                 * FIXME 看的答案
                 *      遍历时间t,从最小值（1）到最大值（全给最慢的机械师），判断时间t内所有工程师能修的车是否大于target。
                 *      目标是在大于等于target的情况下，最小的时间。由于时间和修车数量都是单调递增的，可以用二分法找时间
                 */

                long l = 1;//速度最快的机械师
                int min = Arrays.stream(ranks).min().getAsInt();
                long r = (long) min * cars * cars;//速度最慢的机械师，上限100 FIXME:还可以取更精确的值
                long left = r;// 求左边界
                while (l <= r) {
                    long mid = l + (r - l) / 2;
//                    System.out.println("l=" + l + " r=" + r + " mid=" + mid);
                    if (check(mid, ranks) >= cars) {
                        left = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                return left;

            }

            private long check(long time, int[] ranks) {
                long sum = 0;
                for (int rank : ranks) {//r*n*n = time
                    sum += Math.sqrt(time / rank);//FIXME cast long to double 会慢很多
                }
//                System.out.println("time=" + time + " sum=" + sum);
                return sum;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n² 分钟内修好
// n 辆车。 
//
// 同时给你一个整数 cars ，表示总共需要修理的汽车数目。 
//
// 请你返回修理所有汽车 最少 需要多少时间。 
//
// 注意：所有机械工可以同时修理汽车。 
//
// 
//
// 示例 1： 
//
// 
//输入：ranks = [4,2,3,1], cars = 10
//输出：16
//解释：
//- 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
//- 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
//- 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
//- 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//16 分钟是修理完所有车需要的最少时间。
// 
//
// 示例 2： 
//
// 
//输入：ranks = [5,1,8], cars = 6
//输出：16
//解释：
//- 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
//- 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//- 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
//16 分钟时修理完所有车需要的最少时间。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ranks.length <= 10⁵ 
// 1 <= ranks[i] <= 100 
// 1 <= cars <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 👍 234 👎 0
