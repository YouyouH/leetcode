  //如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的： 
//
// 
// n >= 3 
// 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2} 
// 
//
// 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。 
//
// （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 
//是 [3, 4, 5, 6, 7, 8] 的一个子序列） 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入: arr = [1,2,3,4,5,6,7,8]
//输出: 5
//解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
// 
//
// 示例 2： 
//
// 
//输入: arr = [1,3,7,11,12,14,18]
//输出: 3
//解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 1000 
// 
// 1 <= arr[i] < arr[i + 1] <= 10^9 
// 
// 
//
// 
//
// 注意：本题与主站 873 题相同： https://leetcode-cn.com/problems/length-of-longest-
//fibonacci-subsequence/ 
// Related Topics 数组 哈希表 动态规划 👍 31 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-05-04 21:42:32 
//最长斐波那契数列

  import java.util.HashSet;
  import java.util.Set;

  public class Q91FMA{
    public static void main(String[] args) {

        Solution solution = new Q91FMA().new Solution();

        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 思路:dp[i]表示以array[i]结尾的佩波纳奇序列长度。
         * 则dp[i] 和 dp[i-2] 有什么关系？
         * if(array[i-2] + array[i-1] == array[i])
         * dp[i] = dp[i-2] + 1
         * else
         * dp[]
         * 上面思路错误。
         * <p>
         * 【参考】暴力解法：
         * 斐波那契子序列是有前两个得到第三个，所以可以遍历所有两两组合，然后判断下一个数
         * 是否在集合内(集合是单调递增的所以可以直接在set里面找)。
         */
        public int lenLongestFibSubseq(int[] arr) {
            //建立集合
            Set<Integer> set = new HashSet<>();
            for (int i : arr) {
                set.add(i);
            }

            int count = 0;
            //暴力搜索所有两两组合
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    count = Math.max(count, calculate(arr[i], arr[j], set));
                }
            }
            return count > 2 ? count : 0;
        }

        private int calculate(int a, int b, Set<Integer> set) {
            int count = 2;
            while (set.contains(a + b)) {
                count++;
                int c = a + b;
                a = b;
                b = c;
            }
            return count;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}