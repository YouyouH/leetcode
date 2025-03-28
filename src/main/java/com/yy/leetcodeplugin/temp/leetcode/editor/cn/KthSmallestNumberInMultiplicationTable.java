
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-28 10:56:48 
//乘法表中第k小的数

public class KthSmallestNumberInMultiplicationTable{
    public static void main(String[] args) {
         Solution solution = new KthSmallestNumberInMultiplicationTable().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int findKthNumber(int m, int n, int k) {
                /**
                 * FIXME
                 *  看的答案：
                 *   将问题转化为小于target的数至少K个。
                 *   例如 1,2,2,3,3，  2是第二小的数，3是第三小的数。
                 *   假设求第三小的数，那就转为为小于等于target的数至少有三个。然后继续缩小target.
                 *   此时就可以用二分法解决。
                 *      如何检查小于等于target的数有几个？
                 *          一行一行的判断，对于某一行i，每个数都是i的倍数，所以有target/i个数小于等于target。把每一行累加起来即可。
                 */

                int l = 1;
                int r = m * n;
                int ans = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (check(mid, m, n) >= k) {
                        ans = mid;
                        r = mid - 1;//继续缩小target,让符合条件的数减少。因为mid不一定在表中，所以要不停的缩小范围直到取得最小值
                        //FIXME 为什么最小值一定在表中？
                    } else {
                        l = mid + 1;
                    }
                }
                return ans;
            }

            private long check(int target, int m, int n) {
                long count = 0;
                for (int i = 1; i < m+1; i++) {
                    count += Math.min(n, target / i);//不能比n还大
                }
                return count;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第 k 小的数字吗？ 
//
// 乘法表是大小为 m x n 的一个整数矩阵，其中 mat[i][j] == i * j（下标从 1 开始）。 
//
// 给你三个整数 m、n 和 k，请你在大小为 m x n 的乘法表中，找出并返回第 k 小的数字。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：m = 3, n = 3, k = 5
//输出：3
//解释：第 5 小的数字是 3 。
// 
//
// 示例 2： 
// 
// 
//输入：m = 2, n = 3, k = 6
//输出：6
//解释：第 6 小的数字是 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 3 * 10⁴ 
// 1 <= k <= m * n 
// 
//
// Related Topics 数学 二分查找 👍 377 👎 0
