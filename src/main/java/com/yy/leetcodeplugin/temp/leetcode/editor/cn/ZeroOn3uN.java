//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "10203040"
//输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
//
// 
//
// 注意：本题与主站 93 题相同：https://leetcode-cn.com/problems/restore-ip-addresses/ 
// Related Topics 字符串 回溯 👍 16 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-22 20:17:08
//复原 IP 

import java.util.ArrayList;
import java.util.List;

public class ZeroOn3uN{
    public static void main(String[] args) {
         Solution solution = new ZeroOn3uN().new Solution();
        solution.restoreIpAddresses("25525511135");
        solution.restoreIpAddresses("1111");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            //从题意来看 字符串要按顺序组合，数字顺序不能打乱，只能改变点的位置

            //需要改进的地方：用list代替stringbuild，临时变量太多了，不好？

            if (s.length() > 12) {
                return res;
            }

            restoreIpAddresses0(s,0,new StringBuilder(),0);
            return res;

        }

        private void restoreIpAddresses0(String s, int start, StringBuilder stringBuilder, int depth) {
            if (depth == 4) {
                if (stringBuilder.length() < s.length()+4) {
                    return;
                }else {
                    res.add(new StringBuilder(stringBuilder).deleteCharAt(stringBuilder.length() - 1).toString());
                }
            }
            if (depth > 4) {
                return;
            }

            for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
                String substring = s.substring(start, start + i);
                int value = Integer.parseInt(substring);
                if (value >= 0 && value <= 255) {
                    //001
                    if (substring.startsWith("00")) {
                        continue;
                    }
                    //010
                    if (value > 0 && substring.startsWith("0")) {
                        continue;
                    }
                    restoreIpAddresses0(s, start + i, new StringBuilder(stringBuilder).append(s, start, start + i).append("."), depth + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}