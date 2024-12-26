
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-26 17:24:04 
//统计打字方案数

public class CountNumberOfTexts{
    public static void main(String[] args) {
         Solution solution = new CountNumberOfTexts().new Solution();
        System.out.println(solution.countTexts("22233"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private static final int MOD = 1_000_000_000 + 7;
    public int countTexts(String pressedKeys) {
        /**
         * 穷举
         *  每个数字有三种选择方式，例如2有2，22,222.（9特殊有四种方式）
         *  相当于爬楼梯：
         *      每次可以跨一级，二级或者三级台阶，跨到n级有几种方法？
         *      dp[n] = dp[n-3] + dp[n-2] + dp[n-1]
         *      dp[0]=0;dp[1]=1;dp[2]=2;dp[3]=4;
         *  对于数字9有四种选择，
         *       dp[n] = dp[n-4] + dp[n-3] + dp[n-2] + dp[n-1]
         *
         *  接下来把pressedKeys 划分成一块一块的
         *
         *  添加备忘录：数字9和不是9的单独区分
         *
         *  注意取模问题：
         *      加减乘除都要注意取模
         *
         */
        long ans = 1;
        for (int i = 0; i < pressedKeys.length(); ) {
            long length = 0;
            int j = i;

            //fixme: 这里还可以优化，不要用两个指针，用pressedKeys.charAt(i) 和 pressedKeys.charAt(i+1) 做比较
            for (; j < pressedKeys.length()+1; j++) {
                if(j < pressedKeys.length() && pressedKeys.charAt(j) == pressedKeys.charAt(i)){
                    length++;
                }else {
                    if (pressedKeys.charAt(i) != '9' && pressedKeys.charAt(i) != '7') {
//                        System.out.println("当前字符：" + pressedKeys.charAt(i) + " 长度：" + length);
                        long a1 = 1;
                        long a2 = 2;
                        long a3 = 4;
                        long result = 0;
                        for (int k = 4; k < length+1; k++) {
                            result = a1 + a2 + a3;
                            if (result < 0) {
                                System.out.println(result);
                            }
                            a1 = a2% MOD;
                            a2 = a3% MOD;
                            a3 = result% MOD;
                        }
                        if (length == 1) {
                            result = 1;
                        }
                        if (length == 2) {
                            result = 2;
                        }
                        if (length == 3) {
                            result = 4;
                        }
//                        System.out.println("result=" + result);
                        result = result % MOD;
                        ans = (ans  * result  % MOD)% MOD;
                        break;
                    }else{
//                        System.out.println("当前字符：" + pressedKeys.charAt(i) + " 长度：" + length);
                        long a1 = 1;
                        long a2 = 2;
                        long a3 = 4;
                        long a4 = 8;
                        long result = 0;
                        for (long k = 5; k < length+1; k++) {
                            result = a1 + a2 + a3 + a4;
                            if (result < 0) {
                                System.out.println(result);
                            }
                            a1 = a2% MOD;
                            a2 = a3% MOD;
                            a3 = a4% MOD;
                            a4 = result% MOD;
                        }
                        if (length == 1) {
                            result = 1;
                        }
                        if (length == 2) {
                            result = 2;
                        }
                        if (length == 3) {
                            result = 4;
                        }
                        if (length == 4) {
                            result = 8;
                        }
//                        System.out.println("result=" + result);
                        result = result % MOD;
                        ans = (ans  * result  % MOD)% MOD;
                        break;
                    }
                }
            }
            i = j;
        }
        return (int) (ans% MOD);
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。 
//
// 
//
// 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。 
//
// 
// 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母 'k' 。 
// 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。 
// 
//
// 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。 
//
// 
// 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。 
// 
//
// 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。 
//
// 由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：pressedKeys = "22233"
//输出：8
//解释：
//Alice 可能发出的文字信息包括：
//"aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
//由于总共有 8 种可能的信息，所以我们返回 8 。
// 
//
// 示例 2： 
//
// 
//输入：pressedKeys = "222222222222222222222222222222222222"
//输出：82876089
//解释：
//总共有 2082876103 种 Alice 可能发出的文字信息。
//由于我们需要将答案对 10⁹ + 7 取余，所以我们返回 2082876103 % (10⁹ + 7) = 82876089 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pressedKeys.length <= 10⁵ 
// pressedKeys 只包含数字 '2' 到 '9' 。 
// 
//
// Related Topics 哈希表 数学 字符串 动态规划 👍 88 👎 0
