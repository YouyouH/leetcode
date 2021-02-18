package main

/**
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

    你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/**
当前持有 = max(i-1持有，当前不动 | i-2不持有，当前买入) 为什么不是从i-i转移？因为现在买入，则i-1不能买更不能卖，i-1和i-2是一样的
当前不持有 = max(i-1卖出，当前冷静不动 | i-1买入，当前卖出)
*/
func maxProfit(prices []int) int {
	if nil == prices {
		return 0
	}

	days := len(prices)

	if 0 == days || 1 == days {
		return 0
	}

	dp := make([][]int, days)
	for i := range dp {
		dp[i] = make([]int, 2)
		dp[i][0] = 0
		dp[i][1] = 0
	}

	/**
	0表示不持有
	1表示持有
	*/
	dp[0][0] = 0
	dp[0][1] = -prices[0]
	dp[1][0] = max(0, prices[1]-prices[0])
	dp[1][1] = max(-prices[0], -prices[1])
	for i := 2; i < days; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
		dp[i][1] = max(dp[i-1][1], dp[i-2][0]-prices[i])
	}

	return dp[days-1][0]
}

func max(i int, j int) int {
	if i > j {
		return i
	}
	return j
}
