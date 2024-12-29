
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-28 11:16:06 
//施咒的最大总伤害

import java.util.*;

public class MaximumTotalDamageWithSpellCasting{
    public static void main(String[] args) {
         Solution solution = new MaximumTotalDamageWithSpellCasting().new Solution();
        System.out.println(solution.maximumTotalDamage(new int[]{1, 1, 3, 4}));
        System.out.println(solution.maximumTotalDamage(new int[]{7, 1, 6, 6}));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumTotalDamage(int[] power) {
        /**
         * 穷解：
         *      不合适，数组太长了递归栈深度太大
         *
         * 动态规划：
         *      FIXME: 排序方式不对，数组太长了
         *
         *      FIXME：这道题的难点在于，如何转化为打家劫舍。
         *
         *          跟740删除并获得点数这道题相比，
         *          这两道题目的共同点都是不能取相邻的值，打家劫舍里面是不能取相邻的房子，所以对于这两道题要把值转化为房子，即把值转化为数组下标。
         *
         *          740可以直接把分数转化为数组下标，用一个完整的数组表示所有可能的值（所以大部分都是0）。因为取值范围不大。
         *
         *          这题不能直接把分数转化为下标，因为范围太大了数组太长占用空间太多。所以不能够直接用数组下标表示值，只能按照从小到大顺序排列，
         *          在转化之后不能直接判断相邻的数，相邻的数可以是小于2的所以可以用。需要再加一步判断n-2和相邻的数相比哪个大。
         *
         *
         *
         *     转化为打家劫舍，先要把数组排序，这样才能确保-2-1+1+2处在新数组的相邻位置。
         *     排序方式就是把值当成新数组下标，新数组的值就是所有这个值的和（因为用这个咒语施法了肯定会把所有相同相同伤害的咒语施法不然就浪费了）
         *     例如00112233445566, 如果用了3，那么1245都没了，3肯定要都用掉，也没有别的值可以删掉3
         *
         *  数组要用long类型，因为值最大可以达到10个9。
         *
         *  FIXME:memory 超过限制了不能直接用10个9的数组记录所有的值，只能把有伤害变成数组并排序。
         *  例如 421 转换成数组 124，此时不能直接对这个数组求dp[n]和dp[n-1],因为他们其实是不直接相邻的。
         *  只有转化成01234才能直接求dp（其中124是有值的，其他是0）。对于124,4和1隔了3所以1和4都可以取，因此还需要再判断 dp[n-1] dp[n-2]到底对应的熟悉下标是多少。
         *
         *
         */

//        long[] list = new long[1_000_000_000 + 1];
//        for (int val : power) {
//            list[val] += val; //把伤害值转换为下标， 数组的值是所有相同伤害的累计和，因为如果选了这个咒语所有相同伤害的咒语都要选，不然亏了。
//        }
//
//        long ans = 0;
//
//        long[] dp = new long[1_000_000_000 + 1 +1]; //dp表示前n个咒语的最大值，跟打家劫舍一样
//
//        dp[0] = 0;
//        dp[1] = list[0];
//        dp[2] = Math.max(list[0], list[1]);
//        dp[3] = Math.max(Math.max(list[0], list[1]), list[2]);
//
//        for (int i = 4; i < dp.length; i++) {
//            dp[i] = Math.max(Math.max(dp[i - 3] + list[i-1], dp[i - 2]), dp[i - 1]);
//            ans = Math.max(ans, dp[i]);
//        }
//
//        return ans;

        if (power.length == 1) {
            return power[0];
        }


        Map<Long, Long> map = new HashMap<>();

        for (long val : power) {
            map.merge(val, 1L, Long::sum); //把伤害值转换为下标， 数组的值是所有相同伤害的累计和，因为如果选了这个咒语所有相同伤害的咒语都要选，不然亏了。
                                                //FIXME: 只记录出现的次数，不用记录值。最后计算的时候直接乘一下就行
        }



        //把伤害先存到数组里然后再从小到大排序。打家劫舍是相邻的房子不能选，这里是相邻的伤害不能选
        long[] values = new long[map.size()]; //values表示咒语伤害.相当于打家劫舍里面的房子
        int k = 0;//根据dp的定义要从k=1开始
        for (Long val : map.keySet()) {
            values[k++] = val;
        }
        Arrays.sort(values);//此时就退化成了打家劫舍问题

//        StringBuilder stringBuilder = new StringBuilder();
//        for (int value : values) {
//            stringBuilder.append(value).append(",");
//        }
//
//        System.out.println("房子：" + stringBuilder);

        /**
         * 状态转移公式：
         *  不选第n个咒语，最大值等于前n-1个咒语的最大值
         *  选第n个咒语，最大值等于 前n-3个咒语最大值加上第n个咒语的值
         *
         *  这里要注意： values 数组下标不对应n, 因为如果对应的话，伤害取值范围是10的九次方，太大了。这里values数组里面伤害是从小到大排列的，所以要额外判断相邻的值是不是再-2范围内。
         */

        long[] dp = new long[values.length + 1];

        dp[0] = 0;
        dp[1] = values[0]* map.get(values[0]);


//        System.out.println("dp" + 1 + "=" + dp[1]);
        int j = 0; // j用来判断左边下标
        for (int i = 2; i < dp.length; i++) {
            while (values[j] < values[i-1]-2) {
                j++;
            }
//            System.out.println("i=" + i + "  j=" + j);
            if (j - 1 < 0) {
                dp[i] = Math.max(dp[i - 1], (long) values[i - 1] * map.get(values[i - 1]));
            }else{
                //j确定values数组上的下标，例如j是3，那么相邻的索引就是2，那么dp索引也是2.
                dp[i] = Math.max(dp[i - 1], dp[j] + (long) values[i - 1] * map.get(values[i - 1]));
            }

//            System.out.println("dp" + i + "=" + dp[i]);
        }

        return dp[values.length];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //一个魔法师有许多不同的咒语。 
//
// 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。 
//
// 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] +
// 1 或者 power[i] + 2 的咒语。 
//
// 每个咒语最多只能被使用 一次 。 
//
// 请你返回这个魔法师可以达到的伤害值之和的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：power = [1,1,3,4] 
// 
//
// 输出：6 
//
// 解释： 
//
// 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。 
//
// 示例 2： 
//
// 
// 输入：power = [7,1,6,6] 
// 
//
// 输出：13 
//
// 解释： 
//
// 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。 
//
// 
//
// 提示： 
//
// 
// 1 <= power.length <= 10⁵ 
// 1 <= power[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 动态规划 计数 排序 👍 34 👎 0
