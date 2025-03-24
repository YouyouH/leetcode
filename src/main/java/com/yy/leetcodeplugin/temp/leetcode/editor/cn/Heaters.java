
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-24 17:59:34 
//供暖器

import java.util.Arrays;

public class Heaters{
    public static void main(String[] args) {
         Solution solution = new Heaters().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int findRadius(int[] houses, int[] heaters) {
                /**
                 * FIXME: 看的答案的思路
                 *      对于每一个房子，离最近的heater的记录就是半径。
                 *      所有半径的最大值就是最小加热半径
                 *  怎么找最近的heater?
                 *      对heater排序然后二分搜索。怎么二分？
                 *          求大于等于房子的坐标的最小值，为j。再比较j和j-1看谁更近
                 */

                Arrays.sort(heaters);

                int max = 0;

                for (int i = 0; i < houses.length; i++) {
                    int val = binSearch(houses[i], heaters);
                    max = Math.max(max, val);
                }
                return max;
            }

            private int binSearch(int house, int[] heaters) {

                int l = 0;
                int r = heaters.length - 1;
                int rightBound = 0;
                int leftBound = 0;

                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (heaters[mid] >= house) {
                        rightBound = mid;
                        r = mid - 1;
                    } else {
                        leftBound = mid;
                        l = mid + 1;
                    }
                }

//                System.out.println("house=" + house + " leftBound=" + leftBound + " rightBound=" + rightBound);
                return Math.min(Math.abs(heaters[leftBound] - house), Math.abs(heaters[rightBound] - house));
//
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 注意：所有供暖器 heaters 都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置 2 上有一个供暖器。如果我们将加热半径设为 1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置 1, 4 上有两个供暖器。我们需要将加热半径设为 1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 10⁴ 
// 1 <= houses[i], heaters[i] <= 10⁹ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 👍 506 👎 0
