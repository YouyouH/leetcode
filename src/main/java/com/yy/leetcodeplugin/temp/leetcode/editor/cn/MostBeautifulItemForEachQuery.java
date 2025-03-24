
  
package com.yy.leetcodepugin.temp.leetcode.editor.cn;

//2025-03-24 11:28:54 
//每一个查询的最大美丽值

import java.util.Arrays;
import java.util.Comparator;

public class MostBeautifulItemForEachQuery{
    public static void main(String[] args) {
         Solution solution = new MostBeautifulItemForEachQuery().new Solution();
        solution.maximumBeauty(new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}}, new int[]{1, 2, 3, 4, 5, 6});
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int[] maximumBeauty(int[][] items, int[] queries) {
                /**
                 * 先对items按价格排序，再通过二分法找到小于query的物品，然后遍历这些物品（再用一次排序？）找到最大的美丽值
                 *
                 * FIXME:超时了,求最大值需要改进一下
                 *  排序之后用前缀和的思想记录最大值
                 */
                Arrays.sort(items, Comparator.comparingInt(a -> a[0]));//从大到小排列
                int length = queries.length;

                int max = items[0][1];
                for (int i = 0; i < items.length; i++) {
                    items[i][1] = Math.max(max, items[i][1]);//把值改为前缀序列中的最大值
                    max = items[i][1];
                }

                

                int[] ans = new int[length];
                for (int i = 0; i < length; i++) {
                    ans[i] = binSearch(items, queries[i]);
//                    System.out.println("i=" + i + " ans=" + ans[i]);//1,2  2,4  3,2  3,5  5,6
                }
                return ans;
            }

            private int binSearch(int[][] items, int query) {
                int max = 0;
                int l = 0;
                int r = items.length;//左开右闭。 数组是从小到大排列,求最右边的index
                int left = items.length;

                while (l < r) {
                    int mid = l + (r - l) / 2;
//                    System.out.println("l=" + l + " r=" + r + " mid=" + mid+" items[mid][0]="+items[mid][0]+" query="+query);
                    if (items[mid][0] <= query) {
                        left = mid;
//                        System.out.println("left=" + left);
                        l = mid+1;//左边是开区间
                    }else {
                        r = mid;//右边是闭区间
                    }
                }
//                System.out.println("left=" + left);
                //此时left指向右边界
//                for (int i = left; i >= 0 && i < items.length; i--) {
//                    max = Math.max(max, items[i][1]);
//                }
                return left == items.length ? 0 : items[left][1];//FIXME: 前面已经求出最大值了
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。 
//
// 同时给你一个下标从 0 开始的整数数组 queries 。对于每个查询 queries[j] ，你想求出价格小于等于 queries[j] 的物品中，最大
//的美丽值 是多少。如果不存在符合条件的物品，那么查询的结果为 0 。 
//
// 请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。 
//
// 
//
// 示例 1： 
//
// 输入：items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
//输出：[2,4,5,5,6,6]
//解释：
//- queries[0]=1 ，[1,2] 是唯一价格 <= 1 的物品。所以这个查询的答案为 2 。
//- queries[1]=2 ，符合条件的物品有 [1,2] 和 [2,4] 。
//  它们中的最大美丽值为 4 。
//- queries[2]=3 和 queries[3]=4 ，符合条件的物品都为 [1,2] ，[3,2] ，[2,4] 和 [3,5] 。
//  它们中的最大美丽值为 5 。
//- queries[4]=5 和 queries[5]=6 ，所有物品都符合条件。
//  所以，答案为所有物品中的最大美丽值，为 6 。
// 
//
// 示例 2： 
//
// 输入：items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
//输出：[4]
//解释：
//每个物品的价格均为 1 ，所以我们选择最大美丽值 4 。
//注意，多个物品可能有相同的价格和美丽值。
// 
//
// 示例 3： 
//
// 输入：items = [[10,1000]], queries = [5]
//输出：[0]
//解释：
//没有物品的价格小于等于 5 ，所以没有物品可以选择。
//因此，查询的结果为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= items.length, queries.length <= 10⁵ 
// items[i].length == 2 
// 1 <= pricei, beautyi, queries[j] <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 排序 👍 57 👎 0
