
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-25 22:05:53 
//分配给商店的最多商品的最小值

import java.util.Arrays;

public class MinimizedMaximumOfProductsDistributedToAnyStore{
    public static void main(String[] args) {
         Solution solution = new MinimizedMaximumOfProductsDistributedToAnyStore().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int minimizedMaximum(int n, int[] quantities) {
                /**
                 *二分查找target
                 怎么检查target?
                 限制每个商店只能有一种商品。遍历商品，对于每个商品，最多分配给 quantities[i]/target 个商店。全部加起来商店数量达到n就说明当前target满足要求。接下来可以减小target（缩小右边界）,继续判断能否分配给n个商店
                 *
                 */
                int l = 1;//下限是1
                int r = Arrays.stream(quantities).max().getAsInt();
                int ans = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    int count = check(mid, quantities);
                    if (count <= n) {//为什么是小于等于n? 分给n-1间商店等价于可以分给n间商店（随便找一个商店匀出一个）。
                        ans = mid;
                        r = mid - 1;//为什么要缩小右边界？因为要求最小值
                    } else {//对于当前target,分配的商店数目大于n,不符合题目要求。所以要增大target少分配一点商店。
                        l = mid + 1;
                    }
                }
                return ans;
            }

            /**
             *这里要用贪心算法，每一个商店尽量分配target个商品，因为要让最大值小，就要让每个商店尽量平均的多分配一些商品。
             */
            private int check(int target, int[] quantities) {
                int res = 0;
                for (int q : quantities) {
                    res += (q+target-1) / target;//向上取整，因为要全部分配完，所以余数也得再分配给一间商店
                }
//                System.out.println("target=" + target + " res=" + res);
                return res;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数 n ，表示有 n 间零售商店。总共有 m 种产品，每种产品的数目用一个下标从 0 开始的整数数组 quantities 表示，其中 
//quantities[i] 表示第 i 种商品的数目。 
//
// 你需要将 所有商品 分配到零售商店，并遵守这些规则： 
//
// 
// 一间商店 至多 只能有 一种商品 ，但一间商店拥有的商品数目可以为 任意 件。 
// 分配后，每间商店都会被分配一定数目的商品（可能为 0 件）。用 x 表示所有商店中分配商品数目的最大值，你希望 x 越小越好。也就是说，你想 最小化 分配
//给任意商店商品数目的 最大值 。 
// 
//
// 请你返回最小的可能的 x 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6, quantities = [11,6]
//输出：3
//解释： 一种最优方案为：
//- 11 件种类为 0 的商品被分配到前 4 间商店，分配数目分别为：2，3，3，3 。
//- 6 件种类为 1 的商品被分配到另外 2 间商店，分配数目分别为：3，3 。
//分配给所有商店的最大商品数目为 max(2, 3, 3, 3, 3, 3) = 3 。
// 
//
// 示例 2： 
//
// 
//输入：n = 7, quantities = [15,10,10]
//输出：5
//解释：一种最优方案为：
//- 15 件种类为 0 的商品被分配到前 3 间商店，分配数目为：5，5，5 。
//- 10 件种类为 1 的商品被分配到接下来 2 间商店，数目为：5，5 。
//- 10 件种类为 2 的商品被分配到最后 2 间商店，数目为：5，5 。
//分配给所有商店的最大商品数目为 max(5, 5, 5, 5, 5, 5, 5) = 5 。
// 
//
// 示例 3： 
//
// 
//输入：n = 1, quantities = [100000]
//输出：100000
//解释：唯一一种最优方案为：
//- 所有 100000 件商品 0 都分配到唯一的商店中。
//分配给所有商店的最大商品数目为 max(100000) = 100000 。
// 
//
// 
//
// 提示： 
//
// 
// m == quantities.length 
// 1 <= m <= n <= 10⁵ 
// 1 <= quantities[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 二分查找 👍 64 👎 0
