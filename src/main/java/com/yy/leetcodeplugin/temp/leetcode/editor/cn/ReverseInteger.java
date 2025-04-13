
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-13 20:28:49 
//整数反转

public class ReverseInteger{
    public static void main(String[] args) {
         Solution solution = new ReverseInteger().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x = -x;
        }

        int i = x;
        int sum = 0;
        int last = 0;
        while (i > 0) {
            sum = i % 10 + 10 * sum;
            if (sum / 10 != last) {//FIXME: 这里利用java的技巧，假如溢出了值就不等了
                return 0;
            }
            last = sum;
            i = i / 10;
        }

        return positive ? sum : -sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 4067 👎 0
