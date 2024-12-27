
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-27 16:31:40 
//删除并获得点数

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeleteAndEarn{
    public static void main(String[] args) {
         Solution solution = new DeleteAndEarn().new Solution();
//        System.out.println(solution.deleteAndEarn(new int[]{3}));
//        System.out.println(solution.deleteAndEarn(new int[]{3,4}));
//        System.out.println(solution.deleteAndEarn(new int[]{3, 4, 2}));
//        System.out.println(solution.deleteAndEarn(new int[]{2,2,3,3,3,4}));
//        System.out.println(solution.deleteAndEarn(new int[]{3,4,2,2,2,2,3,4,5,6,7,5,6,5,3}));
        System.out.println(solution.deleteAndEarn(new int[]{1,8,5,9,6,9,4,1,7,3,3,6,3,3,8,2,6,3,2,2,1,2,9,8,7,1,1,10,6,7,3,9,6,10,5,4,10,1,6,7,4,7,4,1,9,5,1,5,7,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {
        int ans = 0;
    public int deleteAndEarn(int[] nums) {
        /**
         * 穷举
         *      超时了
         *
         */

        calculate(nums, 0, new HashMap<>(), 0);

        return ans;
        
    }

        private void calculate(int[] nums, int index, Map<Integer, Integer> deleted, int sum) {
            if (index == nums.length) {
//                System.out.println("最大值：" + sum);
//                ans = Math.max(ans, sum);
                return;
            }

            for (int i = index; i < nums.length; i++) {
                if (deleted.containsKey(nums[i]) && deleted.get(nums[i]) > 0) {
//                    System.out.println("在删除列表，跳过 i=" + i + "数字：" + nums[i]);
                    continue;
                }
                deleted.put(nums[i] - 1, deleted.getOrDefault(nums[i] - 1, 0) + 1);
                deleted.put(nums[i] + 1, deleted.getOrDefault(nums[i] + 1, 0) + 1);
                ans = Math.max(ans, (sum + nums[i])); //要在这里比较最大值,否则上面删除的地方可能会出现跳出循环的情况导致没有机会确定最大值
//                System.out.println("删除index:" + i + " 数字：" + nums[i] + " 总和：" + (sum + nums[i]));
                calculate(nums, i + 1, deleted, sum + nums[i]);

                deleted.put(nums[i] - 1, deleted.getOrDefault(nums[i] - 1, 0) - 1);
                deleted.put(nums[i] + 1, deleted.getOrDefault(nums[i] + 1, 0) - 1);

            }
        }
}

    class Solution {
        int ans = 0;
        public int deleteAndEarn(int[] nums) {
            /**
             * 动态规划：
             * FIXME:看的答案
             *
             *     联想到打家劫舍，在打家劫舍里面，偷了一家之后前后相邻的两家就不能偷了，跟这题有一点相似。
             *
             *     但是要转换成打家劫舍，要先把数组转化成从小到大的顺序，这样才能确保nums[n-1]和nums[n+1] 在nums[n]左右相邻位置。
             *     这里可以将数字转化成新数组的下标，数组的值呢？
             *
             *     删除一个数，就要把这个数全部取了，因为跟他相邻的数都被删了，不取就亏了。所以数组的值可以是所有这个数加起来的值。
             *
             *
             */




        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 哈希表 动态规划 👍 1046 👎 0
