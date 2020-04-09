General problem statement for this pattern can vary but most of the time you are given two strings where lengths of those strings are not big

Statement

    Given two strings s1 and s2, return some result.

Approach

    Most of the problems on this pattern requires a solution that can be accepted in O(n^2) complexity.

**如果条件是两个string,则i,j表示长度为 i 的子串和长度为 j 的子串。**

```
如果条件是两个string,则i,j表示长度为 i 的子串和长度为 j 的子串。
dp[i][j] 表示结果

// i - indexing string s1
// j - indexing string s2
for (int i = 1; i <= n; ++i) {
   for (int j = 1; j <= m; ++j) {
       if (s1[i-1] == s2[j-1]) {
           dp[i][j] = /*code*/;
       } else {
           dp[i][j] = /*code*/;
       }
   }
}
```

**如果条件是给一个string,则外层循环表示string 长度，从1开始。**

```
If you are given one string s the approach may little vary
如果条件是给一个string,则外层循环表示string 长度，从1开始。
i,j表示string 起点和终点。 j = l + 1;

for (int l = 1; l < n; ++l) {
   for (int i = 0; i < n-l; ++i) {
       int j = i + l;
       if (s[i] == s[j]) {
           dp[i][j] = /*code*/;
       } else {
           dp[i][j] = /*code*/;
       }
   }
}
```