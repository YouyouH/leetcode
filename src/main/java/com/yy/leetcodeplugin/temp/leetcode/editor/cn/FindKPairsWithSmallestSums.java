
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-28 15:15:17 
//查找和最小的 K 对数字

import java.util.*;

public class FindKPairsWithSmallestSums{
    public static void main(String[] args) {
         Solution solution = new FindKPairsWithSmallestSums().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        /**
         *FIXME:  看的答案，最小堆实现
         *  0,0是最小的，先土堆。然后添加0,1和1,0。
         *  但是有一个问题：
         *      0,1 和 1,0 出堆的时候分别会添加1,1/0,2 以及 1,1/2,0  这里出现了重复的1,1.需要避免重复的情况下。
         *  解决方案一：用哈希表记录添加过的索引。
         *  解决方案二：
         *      看答案
         */
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<Long> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        set.add(0L);

        while (res.size() < k) {
            int[] min = queue.poll();
            int i = min[1];
            int j = min[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));

            if(i+1 < nums1.length && !set.contains((i+1)*1_000_000_000L+j)) {
                set.add((i + 1) * 1_000_000_000L + j);
                queue.offer(new int[]{nums1[i + 1]+nums2[j], i + 1, j});
            }
            if(j+1 < nums2.length && !set.contains(i*1_000_000_000L+j+1)) {
                set.add(i*1_000_000_000L+j+1);
                queue.offer(new int[]{nums1[i]+nums2[j + 1], i, j + 1});
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
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
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
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
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1 和 nums2 均为 升序排列 
// 
// 1 <= k <= 10⁴ 
// k <= nums1.length * nums2.length 
// 
//
// Related Topics 数组 堆（优先队列） 👍 655 👎 0
