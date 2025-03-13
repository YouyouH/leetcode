
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-12 22:25:30 
//找到 K 个最接近的元素

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements{
    public static void main(String[] args) {
         Solution solution = new FindKClosestElements().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /**
         * 用滑动窗口。窗口大小为k。同时记录窗口内差距最大的值 maxdiff。
         *  1.往窗口内添加数字，直到窗口大小为k。
         *  2.检查下一个数字，
         *      a.如果差距小于 maxdiff,收缩左边数字，更新maxdiff，往右扩张
         *      b.如果下一个数字跟上一个相同，往右扩张。此时有可能窗口大小超出K？
         *  3.再检查下一个数字，如果差距大于maxdiff，停下，返回两指针间的数字即为答案。
         */
        int length = arr.length;
        int l = 0;
        int r = 0;
        int maxDiff = 0;
        for (r = 0; r < length; r++) {
            int diff = Math.abs(arr[r] - x);
            if (r - l + 1 <= k) {
                maxDiff = Math.max(maxDiff, diff);
                continue;
            }
            if (arr[r] == arr[l]) {//FIXME: 如果值相同窗口整体向右移动
                l++;
                maxDiff = Math.max(maxDiff, diff);
                continue;
            }
//            System.out.println("l=" + l + " r=" + r);
            if (diff < maxDiff) {
                //说明最左边距离最远，收缩左边
                l++;
                maxDiff = Math.abs(arr[l] - x);
            }else{
                break;
            }
        }
//        System.out.println("---=" + l + " r=" + r);
        List<Integer> res = new ArrayList<>();
        for (int i = l; i < r; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,2,3,4,5], k = 4, x = -1
//输出：[1,1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴
// 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 滑动窗口 堆（优先队列） 👍 603 👎 0
