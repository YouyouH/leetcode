//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
// Related Topics 字符串 动态规划 👍 21 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-04 20:48:09
//回文子字符串的个数

public class A7VOhD{
    public static void main(String[] args) {
         Solution solution = new A7VOhD().new Solution();
        solution.countSubstrings("abccba");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        //第一层循环确定起始点，第二层循环确定子字符串长度
        //长度为 1 的都是回文子串
        //长度为 2 的要全部判断一遍
        //长度大于等于 3 的可以基于前面的来判断
        //dp[i][j] = dp[i+19][i+j-1] && char[i] && char[j]
        //dp[0][3] = dp[1][(3-1)-1] && char[0] == char[2]
        int count = 0;

        int length = s.length();

        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 1;
        }

        boolean[][] dp = new boolean[length + 1][length + 1];
        //初始化长度为1的子串
        for (int i = 0; i < length; i++) {
            dp[0][i] = true;
            dp[1][i] = true;
            count++;
        }

        //i表示子字符串长度
        for (int i = 2; i < length+1; i++) {
            //j表示起始位置. j+i <length
            for (int j = 0; j < length-i+1; j++) {
                dp[i][j] = dp[i - 2][j + 1] && chars[j] == chars[j + (i - 2) + 1];
                if (dp[i][j]) {
                    count++;
                    System.out.println(i+","+j);
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static class ZVAVXX{
        public static void main(String[] args) {
             Solution solution = new ZVAVXX().new Solution();
            solution.numSubarrayProductLessThanK(new int[]{10,5,2,6},100);
        }
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            //滑动窗口，left表示左边，right表示右边
            //右边先移动，超出k之后再移动左边
            //右边每移动一格，就新增 right-left+1个子集
            int res = 0;
            int left = 0;

            int max = 1;

            for (int right = 0; right < nums.length; right++) {
                max *= nums[right];

                //如果大于K就收缩左边指针，直到小于k
                while (left < nums.length && left <= right && max >= k) {
                    max /= nums[left];
                    left++;
                    //移动左边界缩小窗口
                }
                res += right - left + 1;
            }
            return res;


    //        太慢了！！！滑动窗口实现不对

    //        //滑动窗口，i表示起点，j表示窗口大小。
    //        //i不变，扩大窗口大小直到超过k,然后移动i,窗口初始化为0，继续这个过程
    //
    //        int res = 0;
    //        if (k < 0 ) {
    //            return 0;
    //        }
    //
    //        //太慢了！！！滑动窗口实现不对
    //        for (int i = 0; i < nums.length; i++) {
    //            int max = 1;
    //            for (int j = 1; j <= nums.length - i; j++) {
    //                if ((max *= nums[i + j - 1]) < k) {
    //                    res++;
    //                }else {
    //                    //都是正整数，所以一旦超过后面的就不用考虑了
    //                    break;
    //                }
    //            }
    //        }
    //        return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    }
}