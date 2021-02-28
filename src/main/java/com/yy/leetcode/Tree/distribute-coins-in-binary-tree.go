package Tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。

在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。

返回使每个结点上只有一枚硬币所需的移动次数。



示例 1：

输入：[3,0,0]
输出：2
解释：从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distribute-coins-in-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

type count struct {
	count int
}

//抄的
func distributeCoins(root *TreeNode) int {
	counter := count{count: 0}
	dfs(root, &counter)
	return counter.count
}

func dfs(node *TreeNode, c *count) int {
	if node == nil {
		return 0
	}
	L := dfs(node.Left, c)
	R := dfs(node.Right, c)
	c.count += abs(L) + abs(R)
	return node.Val + L + R - 1

}

func abs(val int) int {
	if val > 0 {
		return val
	}
	return -val
}
