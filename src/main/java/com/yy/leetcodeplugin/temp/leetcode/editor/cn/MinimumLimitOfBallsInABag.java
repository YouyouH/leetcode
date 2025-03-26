
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-25 22:44:47 
//袋子里最少数目的球

import java.util.Arrays;

public class MinimumLimitOfBallsInABag{
    public static void main(String[] args) {
         Solution solution = new MinimumLimitOfBallsInABag().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int minimumSize(int[] nums, int maxOperations) {
                /**
                 * 二分查找开销。开销要满足操作次数小于等于maxOperations时的开销。（因为题目要求至多操作 maxOperations）
                 *      开销定义为所有袋子中球的个数的最大值，那么就是求通过最大操作次数可以得到的袋子中球的最大个数的最小值。
                 *          可以通过贪心分配球，然后检查对于target能否在maxOperations之内完成分配。怎么求对于某个target所需要的分配次数？
                 *      例如9个球，开销是4，那么先分成 5,4，再把5分成1,4，最后得到1,4,4，需要两次操作。 9/4 =3(向上取整)，分为三堆。3-1=2。需要两次操作。
                 *          怎么理解？ 例如9分成了三堆，每次操作相当于增加一堆。最开始是一堆，所以3-1=2，需要两次操作增加两堆。
                 */

                int l = 1; //最小值是1因为袋子里要有球
                int r = Arrays.stream(nums).max().getAsInt();//最大值就是不做操作

                int ans = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (check(mid, nums) <= maxOperations) {
                        ans = mid;
                        r = mid - 1;//缩小最大值，让操作数逼近maxOperations
                    } else {
                        l = mid + 1;
                    }
                }
                return ans;
            }

            private long check(int target, int[] nums) {
                long count = 0;
                for (int num : nums) {
                    int pack = (num + target - 1) / target;//分成pack堆
                    count += pack - 1;//例如将一袋球分成4袋需要3次操作
                }
                return count;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。 
//
// 你可以进行如下操作至多 maxOperations 次： 
//
// 
// 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。 
// 
//
// 
// 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。 
// 
// 
//
//
// 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。 
//
// 请你返回进行上述操作后的最小开销。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [9], maxOperations = 2
//输出：3
//解释：
//- 将装有 9 个球的袋子分成装有 6 个和 3 个球的袋子。[9] -> [6,3] 。
//- 将装有 6 个球的袋子分成装有 3 个和 3 个球的袋子。[6,3] -> [3,3,3] 。
//装有最多球的袋子里装有 3 个球，所以开销为 3 并返回 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,4,8,2], maxOperations = 4
//输出：2
//解释：
//- 将装有 8 个球的袋子分成装有 4 个和 4 个球的袋子。[2,4,8,2] -> [2,4,4,4,2] 。
//- 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,4,4,4,2] -> [2,2,2,4,4,2] 。
//- 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,4,4,2] -> [2,2,2,2,2,4,2] 。
//- 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2] 。
//装有最多球的袋子里装有 2 个球，所以开销为 2 并返回 2 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,17], maxOperations = 2
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= maxOperations, nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 299 👎 0
