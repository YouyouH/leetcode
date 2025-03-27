
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-27 13:58:28 
//礼盒的最大甜蜜度

import java.util.Arrays;

public class MaximumTastinessOfCandyBasket{
    public static void main(String[] args) {
         Solution solution = new MaximumTastinessOfCandyBasket().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int maximumTastiness(int[] price, int k) {
                /**
                 * 二分法求答案
                 *      检查在给定的甜蜜度下，任意两种糖果的价格差最小值都大于给定的甜蜜度，则这个甜蜜度是合格的，可以继续检查更大的甜蜜度。
                 */
                Arrays.sort(price);
                int l = 0;//绝对值最小是0
//                int r = Arrays.stream(price).max().getAsInt();//FIXME： 这里范围还可以缩小，因为检查每一个值的代价比较大，所以要尽量缩小范围。
                int r = price[price.length - 1] - price[0]/k;
                int ans = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (check(mid, price) >=k) {
                        ans = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                return ans;
            }

            //用二分找下一个数
            private int check(int target, int[] price) {
                //排序，前后两个数的差的绝对值大于等于target，一个有几个数
                //1,2,5,8,13,21
                int count = 1;
                int pre = price[0];
                for (int i = 1; i < price.length; i++) {
                    if (price[i] - pre >= target) {
                        count++;
                        pre = price[i];
                    }
                }
//                System.out.println("target=" + target + " count=" + count);
                return count;
            }

            //太慢了
            private int check2(int target, int[] price) {
                //排序，前后两个数的差的绝对值大于等于target，一个有几个数
                //1,2,5,8,13,21
                int count = 1;
                int pre = price[0];
                for (int i = 1; i < price.length; i++) {
                    if (price[i] - pre >= target) {
                        count++;
                        pre = price[i];
                    }
                }
//                System.out.println("target=" + target + " count=" + count);
                return count;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。 
//
// 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。 
//
// 返回礼盒的 最大 甜蜜度。 
//
// 
//
// 示例 1： 
//
// 
//输入：price = [13,5,1,8,21,2], k = 3
//输出：8
//解释：选出价格分别为 [13,5,21] 的三类糖果。
//礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
//可以证明能够取得的最大甜蜜度就是 8 。
// 
//
// 示例 2： 
//
// 
//输入：price = [1,3,1], k = 2
//输出：2
//解释：选出价格分别为 [1,3] 的两类糖果。 
//礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
//可以证明能够取得的最大甜蜜度就是 2 。
// 
//
// 示例 3： 
//
// 
//输入：price = [7,7,7,7], k = 2
//输出：0
//解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= k <= price.length <= 10⁵ 
// 1 <= price[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 二分查找 排序 👍 185 👎 0
