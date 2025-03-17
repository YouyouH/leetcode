
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-17 10:23:17 
//分割两个字符串得到回文串

public class SplitTwoStringsToMakePalindrome{
    public static void main(String[] args) {
        Solution solution = new SplitTwoStringsToMakePalindrome().new Solution();
        System.out.println(solution.checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));

//        "aejbaal  flrmkswrydwdkdwdyrwskmrlf qizjezd"
//        "uvebspqc  kawkhbrtlqwblfwzfptanhig laabjea"
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            /**
             * 双指针，从a的左边和b的右边开始检查，或者 从b的左边和a的右边开始检查
             *   特判：a或者b自身也可以是回文串
             */
            int length = a.length();
            int l = 0;
            int r = length - 1;
            char[] aCharArray = a.toCharArray();
            char[] bCharArray = b.toCharArray();
            //判断a自身
//            if (selfCheck(l, r, aCharArray)) return true;
//            //判断b自身
//            if (selfCheck(l, r, bCharArray)) return true;
//            if(crossCheck(l,r,aCharArray,bCharArray)) return true;
//            if(crossCheck(l,r,bCharArray,aCharArray)) return true;

            if(crossCheck(l, r, length, aCharArray, bCharArray)) return true;
            if(crossCheck(l, r, length, bCharArray, aCharArray)) return true;

            return false;

        }

        private boolean crossCheck(int l, int r, int length, char[] aCharArray, char[] bCharArray) {
            //枚举切点？太慢了。要找规律。
            while (l <= r && l < length && r >= 0) {
                if (aCharArray[l] != bCharArray[r]) {
                    //此时l指向第一个不一样的字符，必须要在此处分割，然后去b上接着判断
                    break;
                }
                l++;
                r--;
            }
//            System.out.println("l="+ l +" r="+ r);
            int l0 = l;
            int r0 = r;

            boolean checkb = true;
            while (l0 <r0) {
                if (bCharArray[l0] != bCharArray[r0]) {
                    checkb = false;
                }
                l0++;
                r0--;
            }
            if(checkb) return true;

            int l1 = l;
            int r1 = r;
            while (l1 <= r1) {
                if (aCharArray[l1] != aCharArray[r1]) {
                    return false;
                }
                l1++;
                r1--;
            }
            return true;
        }

        private boolean selfCheck(int l, int r, char[] chars) {
            while (l <= r) {
                if (chars[l] != chars[r]) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 
//asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = 
//bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。 
//
// 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么
// "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。 
//
// 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。 
//
// 注意， x + y 表示连接字符串 x 和 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = "x", b = "y"
//输出：true
//解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
//aprefix = "", asuffix = "x"
//bprefix = "", bsuffix = "y"
//那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：a = "xbdef", b = "xecab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：a = "ulacfd", b = "jizalu"
//输出：true
//解释：在下标为 3 处分割：
//aprefix = "ula", asuffix = "cfd"
//bprefix = "jiz", bsuffix = "alu"
//那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁵ 
// a.length == b.length 
// a 和 b 都只包含小写英文字母 
// 
//
// Related Topics 双指针 字符串 👍 162 👎 0
