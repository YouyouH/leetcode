  //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3681 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-23 16:31:54 
//爬楼梯

  import java.util.HashMap;
  import java.util.Map;

  public class ClimbingStairs{
    public static void main(String[] args) {
         Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int climbStairs(int n) {
        /**
         * 穷举： 从上往下递归
         * 可以先画出
         */
        int result = 0;
        if (n == 0) return 1;//最后一步是0说明爬到楼顶了，此时才计数为1.
        if (n < 0) return 0; //失败了
        for (int i = 1; i < 3; i++) {
            result += climbStairs(n - i);//注意不是求总的登顶步数，只需要知道能否登顶，所以不能写成 1+climbStairs(n - i)
        }
        return result;
    }
}

      class Solution2 {
          Map<Integer, Integer> memo = new HashMap<>();
          public int climbStairs(int n) {
              /**
               * 穷举： 从上往下递归
               * 加上备忘录，否则会超时
               */

              int result = 0;
              if (memo.containsKey(n)) {
                  return memo.get(n);
              }
              if (n == 0) return 1;
              if (n < 0) return 0;
              for (int i = 1; i < 3; i++) {
                  result += climbStairs(n - i);
              }
              memo.put(n, result);
              return result;
          }
      }

      class Solution3 {
          Map<Integer, Integer> memo = new HashMap<>();
          public int climbStairs(int n) {
              /**
               * 从下往上迭代.状态转移公式:
               * dp[n] = dp[n-1] + dp[n-2]
               * 爬到n级台阶的方式 等于 爬到 n-1 再加上爬到 n-2 (再往上一级或者两级就能到达)
               * 为什么不包括n-3?
               *    n-3再加一就是n-2,再加二就是n-1，所以n-3这种情况已经被包括了
               *
               * 初始状态 dp[0]=0;
               */
              if (n == 1 ) {
                  return 1;
              }
              int[] dp = new int[n+1];
              dp[0] = 0;
              dp[1] = 1;
              dp[2] = 2;

              for (int i = 3; i <= n; i++) {
                  dp[i] = dp[i - 1] + dp[i - 2];
              }

              return dp[n];

          }
      }

      class Solution {
          Map<Integer, Integer> memo = new HashMap<>();
          public int climbStairs(int n) {
              /**
               * 从下往上迭代.状态转移公式:
               * dp[n] = dp[n-1] + dp[n-2]
               * 爬到n级台阶的方式 等于 爬到 n-1 再加上爬到 n-2 (再往上一级或者两级就能到达)
               * 为什么不包括n-3?
               *    n-3再加一就是n-2,再加二就是n-1，所以n-3这种情况已经被包括了
               *
               * 初始状态 dp[0]=0;
               *
               *
               * 进一步优化：
               *    不需要记录完整的dp数组，只需要记录前两个值就行
               */
              if (n == 1 ) {
                  return 1;
              }
              if (n == 2) {
                  return 2;
              }
//              int[] dp = new int[n+1];
//              dp[0] = 0;
//              dp[1] = 1;
//              dp[2] = 2;

              int n1 = 2;
              int n2 = 1;

              int result = 0;

              for (int i = 3; i <= n; i++) {
//                  dp[i] = dp[i - 1] + dp[i - 2];
                  result = n1 + n2;
                  n2 = n1;
                  n1 = result;
              }

              return result;

          }
      }
//leetcode submit region end(Prohibit modification and deletion)

}