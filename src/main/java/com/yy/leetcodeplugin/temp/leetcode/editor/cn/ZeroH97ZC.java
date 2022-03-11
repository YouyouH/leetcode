  //给定两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
//
// 
//
// 注意：本题与主站 1122 题相同：https://leetcode-cn.com/problems/relative-sort-array/ 
// Related Topics 数组 哈希表 计数排序 排序 👍 18 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-11 00:04:21 
//数组相对排序

  import java.util.ArrayList;
  import java.util.List;
  import java.util.Map;
  import java.util.TreeMap;

  public class ZeroH97ZC{
    public static void main(String[] args) {
         Solution solution = new ZeroH97ZC().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : arr1) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : arr2) {
            Integer count = treeMap.get(i);
            while (count-- > 0) {
                res.add(i);
            }
            //只留下没用过的
            treeMap.remove(i);
        }
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            while (count-- > 0) {
                res.add(key);
            }
        }
        return res.stream().mapToInt(a -> a).toArray();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}