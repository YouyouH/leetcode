String

回文子串PalindromicSubstrings：

Related:

1. [PalindromicSubstrings](E:\projects\leetcode\src\main\java\com\yy\leetcode\String\PalindromicSubstrings.java)
2. [LongestPalindromicSubstring]()

解题方法：

1. 中心法 
   - 确定所有可能的回文中心
     - 2n-1个中心点
   - 往两边延伸
2. 动态规划法
   - dp(i)(j) 如果是回文子串，则dp(i+1)(j-1)也是回文子串



中心法和动态规划法原理是一样的，就是从最小的回文子串(一个字符或者两个字符)开始，不断的同时的往两边扩展。



------

括号问题：



解题方法：

1. stack.遇到左括号就进栈，遇到右括号就判断栈顶是不是左括号，如果是则出栈，表示遇到一对括号。



------

字符串匹配：

1. 回溯