package main

//给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
//
//实现 NumArray 类：
//
//    NumArray(int[] nums) 使用数组 nums 初始化对象
//    int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/range-sum-query-immutable
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
type NumArray struct {
	cache []int
}

//前缀和，先把前i个数的和计算并缓存起来
func Constructor(nums []int) NumArray {
	cache := make([]int, len(nums)+1)
	cache[0] = 0
	for i := 1; i < len(nums)+1; i++ {
		cache[i] = cache[i-1] + nums[i-1]
	}
	return NumArray{
		cache: cache,
	}
}

func (this *NumArray) SumRange(i int, j int) int {
	return this.cache[j+1] - this.cache[i]
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(i,j);
 */
