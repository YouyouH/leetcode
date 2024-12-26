
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-26 14:44:53 
//统计构造好字符串的方案数

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountWaysToBuildGoodStrings{
    public static void main(String[] args) {
         Solution solution = new CountWaysToBuildGoodStrings().new Solution();
        System.out.println(solution.countGoodStrings(2, 3, 1, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {

        long result = 0;
    public int countGoodStrings(int low, int high, int zero, int one) {
        /**
         * 穷举
         *
         * 超时了，要加备忘录, 用字符串当前长度作为key？ 怎么加？？
         *
         */
        generate(low, high, zero, one, new StringBuilder());

        return (int) (result%(Math.pow(10,9)+7));
        
    }

        private void generate(int low, int high, int zero, int one, StringBuilder sb) {

            if (sb.length() >= low && sb.length() <= high) {
                result++;
            }
            if (sb.length() > high) {
                return;
            }

            //添加0
            for (int i = 0; i < zero; i++) {
                sb.append('0');
            }
            generate(low, high, zero, one, sb);

            for (int i = 0; i < zero; i++) {
                sb.deleteCharAt(sb.length() - 1);
            }
            //添加1
            for (int i = 0; i < one; i++) {
                sb.append('1');
            }
            generate(low, high, zero, one, sb);
            for (int i = 0; i < one; i++) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
}

    class Solution {
        private static final int MOD = 1_000_000_000 + 7;
        int count = 0;

        public int countGoodStrings(int low, int high, int zero, int one) {
            /**
             * 穷举
             *     题目要求是low到high,可以把Solution2 拆分成下面这种形式，然后把答案加起来，这样比较好实现而且可以加备忘录。
             *     Solution2 没想到怎么加备忘录
             *
             *     备忘录怎么写？
             *      用剩余字符串长度当key，这样可以减少递归次数
             *
             *      加了备忘录还是超时？
             *          对于case: [45360,45360,45360,2]  答案是2. 从0开始构建字符串的方式就超时了。？？？
             *
             *     FIXME: 可能不是从头创建字符串的问题，真正的问题是不需要创建字符串，只需要用长度表示字符串就行。
             *
             *
             */
            int ans = 0;
            Map<Integer, Integer> memo = new HashMap<>();
            for (int i = low; i <= high; i++) {
                ans += (generate(i, zero, one, new StringBuilder(), memo) % MOD);
            }
            System.out.println("memo reached：" + count);

            return ans%MOD;

        }

        private int generate(int length, int zero, int one, StringBuilder sb, Map<Integer, Integer> memo) {

            if (sb.length() == length) {
                return 1;
            }
            if (sb.length() > length) {
                return 0;
            }
            if (memo.containsKey(length-sb.length())) {
                count++;
                return memo.get(length-sb.length());
            }

            int result = 0;

            //添加0
            for (int i = 0; i < zero; i++) {
                sb.append('0');
            }
            result += generate(length, zero, one, sb, memo)% MOD;

            for (int i = 0; i < zero; i++) {
                sb.deleteCharAt(sb.length() - 1);
            }
            //添加1
            for (int i = 0; i < one; i++) {
                sb.append('1');
            }
            result += generate(length, zero, one, sb, memo)% MOD;
            for (int i = 0; i < one; i++) {
                sb.deleteCharAt(sb.length() - 1);
            }
            result = result % MOD;
            memo.put(length-sb.length(), result);
            return result;
        }
    }


    //下面这个是抄的，是从length开始减
    class Solution3 {
        private static final int MOD = 1_000_000_007;
        int count = 0;
        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] memo = new int[high + 1];
            Arrays.fill(memo, -1); // -1 表示没有计算过
            int ans = 0;
            for (int i = low; i <= high; i++) {
                ans = (ans + dfs(i, zero, one, memo)) % MOD;
            }
            System.out.println("memo reached：" + count);
            return ans;
        }

        private int dfs(int i, int zero, int one, int[] memo) {
            if (i < 0) {
                return 0;
            }
            if (i == 0) {
                return 1;
            }
            if (memo[i] != -1) { // 之前计算过
                count++;
                return memo[i];
            }
            return memo[i] = (dfs(i - zero, zero, one, memo) + dfs(i - one, zero, one, memo)) % MOD;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}

  //给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种： 
//
// 
// 将 '0' 在字符串末尾添加 zero 次。 
// 将 '1' 在字符串末尾添加 one 次。 
// 
//
// 以上操作可以执行任意次。 
//
// 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。 
//
// 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：low = 3, high = 3, zero = 1, one = 1
//输出：8
//解释：
//一个可能的好字符串是 "011" 。
//可以这样构造得到："" -> "0" -> "01" -> "011" 。
//从 "000" 到 "111" 之间所有的二进制字符串都是好字符串。
// 
//
// 示例 2： 
//
// 输入：low = 2, high = 3, zero = 1, one = 2
//输出：5
//解释：好字符串为 "00" ，"11" ，"000" ，"110" 和 "011" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= low <= high <= 10⁵ 
// 1 <= zero, one <= low 
// 
//
// Related Topics 动态规划 👍 104 👎 0
