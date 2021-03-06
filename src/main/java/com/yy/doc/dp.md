### Dynamic Programming

------

模板1：


```java
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 择优(选择1，选择2...)
```

1. 找状态
2. 定义dp(i)(j)
3. 写出状态转移方程



模板2：

```java
backtracking + DP table
```

这种方式其实是暴力方法计算所有可能，但是由于存在重复的计算所以用DP table把中间结果存起来进行复用。



------


DP(i)(j)表示的是状态，注意状态之间的转换。即当前状态可能由多种状态转移而来。

比如卖股票类的题目，dp[i][j] 表示当前的状态是持有还是不持有。

当前为持有状态可能由

    1.之前持有，现在不买
    2.之前持有，现在买
    3.之前不持有，现在买入

转换而来。

