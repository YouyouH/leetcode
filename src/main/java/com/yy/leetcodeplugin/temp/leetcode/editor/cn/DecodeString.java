
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-13 12:18:54 
//字符串解码

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString{
    public static void main(String[] args) {
         Solution solution = new DecodeString().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public String decodeString(String s) {
                /**
                 * 用stack解决。
                 *  遍历s,遇到左括号，或者数字，或者连续字符，或者左括号，都入栈。遇到右括号，出栈，计算之后再入栈
                 *  例如 "3[a2[c]]", 3入栈，a入栈，2入栈，c入栈。 遇到右括号之后出栈两次进行计算，然后再入栈
                 *
                 *  FIXME 效率不够高，答案用的辅助栈
                 */
                Deque<String> stack = new ArrayDeque<>();
//                stack.push("");

                char[] array = s.toCharArray();
                for (int i = 0; i < array.length; ) {
                    StringBuilder sb = new StringBuilder();
                    while (i < array.length && Character.isAlphabetic(array[i])) {
                        sb.append(array[i]);
                        i++;
                    }
                    if (sb.length() != 0) {
                        debug(sb);
                        stack.push(sb.toString());//把字母入栈
                    }

                    sb = new StringBuilder();
                    while (i < array.length && Character.isDigit(array[i])) {
                        sb.append(array[i]);
                        i++;
                    }
                    if (sb.length() != 0) {
                        debug(sb);
                        stack.push(sb.toString());//把数字入栈
                    }
                    if (i<array.length && array[i] == '[') {
                        stack.push("[");
                        i++;//左括号入栈
                    }
                    if (i<array.length  && array[i] == ']') {
                        //遇到右括号,开始计算
                        String str = stack.pop();
                        StringBuilder temp = new StringBuilder();
                        //如果是左括号，则说明前面是数组，要重复。否则就是普通字符，直接拼接起来
                        while (!stack.isEmpty() && !stack.peek().equals("[")) {
                            //不是左括号，则是字母，直接拼起来
                            temp.insert(0, stack.pop());//拼接的时候顺序要反过来，放在最前面
                        }

                        String str2 = stack.pop();//这个是左括号
                        //前面是左括号则下一个弹出的一定是数字
                        int number = Integer.valueOf(stack.pop());

//                       debug(new StringBuilder("计算:" + (temp + str).repeat(number)));
                        stack.push((temp+str).repeat(number));
                        i++;
                    }
                }

                StringBuilder res = new StringBuilder();
                while (!stack.isEmpty()) {
                    res.append(stack.pollLast());
                }
                return res.toString();
            }

            private void debug(StringBuilder sb) {
//                System.out.println(sb);
            }
        }
//leetcode submit region end(Prohibit modification and deletion)
}

  //给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1958 👎 0
