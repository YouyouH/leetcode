  //给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//    [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁴ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1, nums2 均为升序排列 
// 1 <= k <= 1000 
// 
//
// 
//
// 注意：本题与主站 373 题相同：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-
//sums/ 
// Related Topics 数组 堆（优先队列） 👍 19 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-05 18:29:34 
//和最小的 k 个数对

  import java.util.ArrayList;
  import java.util.List;
  import java.util.PriorityQueue;

  public class Qn8gGX{
    public static void main(String[] args) {
         Solution solution = new Qn8gGX().new Solution();
        solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //多路归并,有以下这些序列：
        // nums[0][0], nums[0][1],nums[0][2]...... nums[0][n],
        // nums[1][0], nums[1][1],nums[1][2]...... nums[1][n],
        // ......
        // nums[n][0], nums[n][1],nums[n][2]...... nums[n][n],
        //需要同时归并几个序列

        //小根堆，堆顶加入答案，因为要求的是最小值。有size大小。 堆存数组下标
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k,(a,b)-> nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);
        //i的最大值不能是K，因为k可能大于nums1长度
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            //把这些序列的第一个元素都加入队列排序
            priorityQueue.offer(new int[]{i, 0});
        }

        List<List<Integer>> res = new ArrayList<>();

        while (k-- > 0 && !priorityQueue.isEmpty()) {
            //取出最小的加入答案
            int[] poll = priorityQueue.poll();
            int i = poll[0];
            int j = poll[1];
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(nums1[i]);
            tmp.add(nums2[j]);
            res.add(tmp);
            //注意不要越界。
            if (j + 1 < nums2.length) {
                priorityQueue.offer(new int[]{i, j + 1});
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}