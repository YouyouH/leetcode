package main

//给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
/**
线段树: segmentTree.md
tree[i] = tree[2i] + tree[2i+1]
*/
type NumArray2 struct {
	//[n] - [2n-1] 存储的是原始数组
	//[0] - [n-1] 存储的是处理过的值
	tree []int
	n    int
}

func Constructor2(nums []int) NumArray2 {
	n := len(nums)
	tree := make([]int, 2*n)
	//从[n] 到[2n-1]是
	for i, j := n, 0; i < 2*n; i++ {
		tree[i] = nums[j]
		j++
	}
	//tree[i] = tree[2i]+[2i+1]
	for i := n - 1; i > 0; i-- {
		tree[i] = tree[2*i] + tree[2*i+1]
	}

	return NumArray2{
		tree: tree,
		n:    n,
	}
}

/**
先更新数组，再从下往上更新
*/
func (this *NumArray2) Update(index int, val int) {
	pos := index + this.n
	this.tree[pos] = val
	for pos > 0 {
		right, left := pos, pos
		if pos%2 == 0 {
			right = pos + 1
		} else {
			left = pos - 1
		}
		this.tree[left/2] = this.tree[left] + this.tree[right]
		pos /= 2
	}
}

func (this *NumArray2) SumRange(left int, right int) int {
	left += this.n
	right += this.n
	sum := 0
	for left <= right {
		//left 不是左节点则右移到兄弟节点
		if left%2 == 1 {
			sum += this.tree[left]
			left++
		}
		//right 不是右节点则左移到兄弟节点
		if right%2 == 0 {
			sum += this.tree[right]
			right--
		}
		//上移
		left /= 2
		right /= 2
	}
	return sum
}

/**
 * Your NumArray2 object will be instantiated and called as such:
 * obj := Constructor(nums);
 * obj.Update(index,val);
 * param_2 := obj.SumRange(left,right);
 */
