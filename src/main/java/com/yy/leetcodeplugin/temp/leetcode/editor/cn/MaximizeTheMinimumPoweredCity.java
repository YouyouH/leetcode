
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-31 16:47:38 
//最大化城市的最小电量

import java.util.Arrays;

public class MaximizeTheMinimumPoweredCity{
    public static void main(String[] args) {
         Solution solution = new MaximizeTheMinimumPoweredCity().new Solution();
        solution.maxPower(new int[]{1, 2, 4, 5, 0}, 1, 2);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public long maxPower(int[] stations, int r, int k) {
                /**
                 * FIXME 看的答案
                 *  先用前缀和求每个城市的电量
                 */
                int length = stations.length;

                //先求每个城市的电量
                long[] sum = new long[length + 1];//FIXME: 为什么是length+1? 方便处理sum[0]
                for (int i = 0; i < length; i++) {
                    sum[i + 1] = sum[i] + stations[i];
                }

                long[] power = new long[length];
                //前缀和求每个城市的电量
                for (int i = 0; i < length; i++) {
                    power[i] = sum[Math.min(length, i + r + 1)] - sum[Math.max(0, i - r)];
                }
                //再用二分法求最小电量的最大值。即在确保最小电量大于等于给定target的情况下能否做到最多只增加K座电站
                long left = 0;
                long right = (long) (Arrays.stream(stations).max().getAsInt() + k) * 2 * (r+1);//最大值取整个半径范围内所有的电站都达到最大值
                long ans = 0;

                while (left <= right) {
                    long mid = left + (right - left) / 2;
                    if (check(power, mid, r, k)) {
                        ans = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                return ans;
            }

            /**
             * FIXME 检查是否能够在最多建造K座电站的情况下让电量最小值都大于等于target
             *  思路：从第一个成城市开始，让每一个城市的电量都达到target,并且累计需要修多少电站。一旦需要修的电站超过K说明不符合条件
             *
             *   这里要用到的一个技巧是 差分数组。因为每次新增电站都需要更新半径内的所有城市的电量，所以对于这种需要频繁更新的场景，可以使用
             *  差分数组的思想，只记录变化的值。
             *  但是这里不是直接应用差分数组，有一些变形。
             */
            private boolean check(long[] power, long target, int r, int k) {
                int len = power.length;
                long[] diffArray = new long[len];
                long sumDiff = 0;//记录城市的电量值的增量
                long need = 0;
                for (int i = 0; i < len; i++) {
                    sumDiff += diffArray[i];

                    long diff = target - power[i] - sumDiff;

                    //FIXME
                    // 说明需要修电站覆盖当前城市，那么就把电站修在离当前城市距离为r的地方，并且更新半径范围内的所有电量。
                    // 注意这里如果直接去更新值会比较慢，我们只要记录（累加）范围内所有城市的电量的增加值即可。
                    if (diff > 0) {
                        need += diff;
                        if (need > k) {//超过K就说明不符合条件
                            return false;
                        }
                        sumDiff += diff;//累加城市的电量值的增量
                        if(i + r + r + 1 < len) {
                            diffArray[i + r + r + 1] -= diff;//差分数组的思想，电站建在i+r处，覆盖到i+r+r,那么 i+r+r+1就要减去diff
                        }
                    }
                }
                return true;

            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个下标从 0 开始长度为 n 的整数数组 stations ，其中 stations[i] 表示第 i 座城市的供电站数目。 
//
// 每个供电站可以在一定 范围 内给所有城市提供电力。换句话说，如果给定的范围是 r ，在城市 i 处的供电站可以给所有满足 |i - j| <= r 且 0
// <= i, j <= n - 1 的城市 j 供电。 
//
// 
// |x| 表示 x 的 绝对值 。比方说，|7 - 5| = 2 ，|3 - 10| = 7 。 
// 
//
// 一座城市的 电量 是所有能给它供电的供电站数目。 
//
// 政府批准了可以额外建造 k 座供电站，你需要决定这些供电站分别应该建在哪里，这些供电站与已经存在的供电站有相同的供电范围。 
//
// 给你两个整数 r 和 k ，如果以最优策略建造额外的发电站，返回所有城市中，最小电量的最大值是多少。 
//
// 这 k 座供电站可以建在多个城市。 
//
// 
//
// 示例 1： 
//
// 
//输入：stations = [1,2,4,5,0], r = 1, k = 2
//输出：5
//解释：
//最优方案之一是把 2 座供电站都建在城市 1 。
//每座城市的供电站数目分别为 [1,4,4,5,0] 。
//- 城市 0 的供电站数目为 1 + 4 = 5 。
//- 城市 1 的供电站数目为 1 + 4 + 4 = 9 。
//- 城市 2 的供电站数目为 4 + 4 + 5 = 13 。
//- 城市 3 的供电站数目为 5 + 4 = 9 。
//- 城市 4 的供电站数目为 5 + 0 = 5 。
//供电站数目最少是 5 。
//无法得到更优解，所以我们返回 5 。
// 
//
// 示例 2： 
//
// 
//输入：stations = [4,4,4,4], r = 0, k = 3
//输出：4
//解释：
//无论如何安排，总有一座城市的供电站数目是 4 ，所以最优解是 4 。
// 
//
// 
//
// 提示： 
//
// 
// n == stations.length 
// 1 <= n <= 10⁵ 
// 0 <= stations[i] <= 10⁵ 
// 0 <= r <= n - 1 
// 0 <= k <= 10⁹ 
// 
//
// Related Topics 贪心 队列 数组 二分查找 前缀和 滑动窗口 👍 58 👎 0
