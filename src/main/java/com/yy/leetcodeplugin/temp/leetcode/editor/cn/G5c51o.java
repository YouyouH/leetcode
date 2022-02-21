  //给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// 
//
// 注意：本题与主站 347 题相同：https://leetcode-cn.com/problems/top-k-frequent-elements/ 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 18 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-19 18:35:36 
//出现频率最高的 k 个数字

  import java.util.*;

  public class G5c51o {
      public static void main(String[] args) {
          Solution solution = new G5c51o().new Solution();
      }

      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int[] topKFrequent(int[] nums, int k) {
              //
              //用一个array表示数字的出现次数
              //再遍历一遍可以得到每个数字的出现频率
              //
              //方法一：
              //如果对频率排序，那时间复杂度是nlogn，不满足要求。？？
              //再用桶排序，把频率当成index，存到array里，再倒序扫描array即可
              //
              //方法二：堆排序
              //维护一个大小为k的小顶堆，然后每遇到一个大于顶树的就把当前顶弹出。时间复杂度为nlogk,满足进阶要求, n是总数，对每一个数还要花logk的时间排序

              // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
              HashMap<Integer, Integer> map = new HashMap();
              for (int num : nums) {
                  if (map.containsKey(num)) {
                      map.put(num, map.get(num) + 1);
                  } else {
                      map.put(num, 1);
                  }
              }
              // 遍历map，用最小堆保存频率最大的k个元素
              PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                  @Override
                  public int compare(Integer a, Integer b) {
                      return map.get(a) - map.get(b);
                  }
              });
              for (Integer key : map.keySet()) {
                  if (pq.size() < k) {
                      pq.add(key);
                  } else if (map.get(key) > map.get(pq.peek())) {
                      pq.remove();
                      pq.add(key);
                  }
              }
              // 取出最小堆中的元素
              List<Integer> res = new ArrayList<>();
              while (!pq.isEmpty()) {
                  res.add(pq.remove());
              }
              return res.stream().mapToInt(Integer::valueOf).toArray();
          }
      }

      //leetcode submit region end(Prohibit modification and deletion)
      class Solution2 {
          public int[] topKFrequent(int[] nums, int k) {
              //
              //用一个array表示数字的出现次数
              //再遍历一遍可以得到每个数字的出现频率
              //
              //方法一：
              //如果对频率排序，那时间复杂度是nlogn，不满足要求。？？
              //再用桶排序，把频率当成index，存到array里，再倒序扫描array即可
              //
              //方法二：堆排序
              //维护一个大小为k的小顶堆，然后每遇到一个大于顶树的就把当前顶弹出。时间复杂度为nlogk, n是总数，对每一个数还要花logk的时间排序

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
              for (int i = array.length - 1; i >= 0 && result.size() < k; i--) {
                  if (array[i] == null) continue;
                  result.addAll(array[i]);
              }
              return result.stream().mapToInt(Integer::valueOf).toArray();
          }
      }
  }