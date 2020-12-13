package com.yy.leetcode.unclear;

import java.util.*;
import java.util.stream.Stream;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequentElements {

    /**
     * //时间复杂度要小于nlogn,所以不能使用排序算法
     * <p>
     * 方法一：最小堆排序，复杂度nlogK (最大堆排序：nlogn)使用prityQueue
     * 方法二：桶排序,复杂度n
     */
    public int[] topKFrequent(int[] nums, int k) {

        return null;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> num2Frequent = new HashMap<>();
        for (int num : nums) {
            num2Frequent.compute(num, (key, value) -> {
                if (null == value) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }

        List<Integer>[] array = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : num2Frequent.entrySet()) {
            Integer num = entry.getKey();
            Integer frequence = entry.getValue();
            if (null == array[frequence]) {
                array[frequence] = new ArrayList<>();
            }
            array[frequence].add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = array.length-1; i>=0 && result.size() < k; i--) {
            if(array[i] == null) continue;
            result.addAll(array[i]);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();

    }
}
