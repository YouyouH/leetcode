  //给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁴ 
// 0 <= t <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 220 题相同： https://leetcode-cn.com/problems/contains-duplicate-iii/ 
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 29 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-04 17:26:52 
//值和下标之差都在给定的范围内

  import org.junit.Assert;

  import java.util.HashMap;
  import java.util.Map;

  public class SevenWqeDu{
    public static void main(String[] args) {

        Solution solution = new SevenWqeDu().new Solution();
        Assert.assertFalse(solution.containsNearbyAlmostDuplicate
                (new int[]{1,5,9,1,5,9},2,3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //方法一：桶排序。每个桶的大小为t+1（例如一个桶可以放0到t，所以桶大小为t+1）
        //但是由于题目只需要判断存不存在，所以一旦一个桶有第二个元素，就表明存在。所以桶排序的时候，一个桶最多只有一个数字。
        //也因直接用hashmap表示桶就行了

        //key是桶id,value是数字
        Map<Long, Long> bucket = new HashMap<>();
        int bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            long index = getIndex(num, bucketSize);
            //桶内已经有元素
            if (bucket.containsKey(index)) {
                return true;
            }
            //检查左右相邻的桶
            if (bucket.containsKey(index - 1) && Math.abs(bucket.get(index - 1) - num) <= t) {
                return true;
            }
            if (bucket.containsKey(index + 1) && Math.abs(bucket.get(index + 1) - num) <= t) {
                return true;
            }
            bucket.put(index, (long) num);
            //移除超出下标的桶??? 确保不要有下标差大于k的值进入同一个桶。
            if (i >= k) {
                bucket.remove(getIndex(nums[i - k], bucketSize));
            }
        }
        return false;
    }
        //如何理解？
        //https://leetcode-cn.com/problems/contains-duplicate-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-dlnv/
        private long getIndex(int num, int bucketSize) {
            if (num >= 0) {
                return num / bucketSize;
            }
            //处理负数
            return (num + 1) / bucketSize - 1;
        }



        //方法二：正常的滑动窗口双重循环，时间复杂度太高了。
        // 需要再结合排序集合，例如treeset对窗口内的数排序
//        int length = nums.length;
//        for (int i = 0; i < length; i++) {
//            int left = i;
//            for (int j = 1; j <= k; j++) {
//                if ((left + j) >= length) {
//                    break;
//                }
//
//                if (Math.abs((long) nums[left] - (long) nums[left + j]) <= t) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}