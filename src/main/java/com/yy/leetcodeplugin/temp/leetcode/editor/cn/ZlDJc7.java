  //一个密码锁由 4 个环形拨轮组成，每个拨轮都有 10 个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', 
//'9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，因为当拨动到 "0102" 时这
//个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// 
//
// 
// 注意：本题与主站 752 题相同： https://leetcode-cn.com/problems/open-the-lock/ 
//
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 23 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-09-06 11:03:13 
//开密码锁

  import java.util.*;
  import java.util.stream.Collectors;

  public class ZlDJc7{
    public static void main(String[] args) {
         Solution solution = new ZlDJc7().new Solution();
        solution.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
    public int openLock(String[] deadends, String target) {
        //BFS 宽度优先搜索。每一层都是转一次圈的所有可能情况（包括正反转）。遇到deadends就删掉
        Set<String> deadMap = Arrays.stream(deadends).collect(Collectors.toSet());

        if (deadMap.contains("0000") || deadMap.contains(target)) {
            return -1;
        }
        String curString = "0000";
        if (curString.equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>(calculateCandidates(curString));
        Set<String> visited = new HashSet<>();
        visited.add(curString);

        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                String number = queue.poll();
                if (Objects.equals(number, target)) {
                    return count;
                }
                if (deadMap.contains(number)) {
                    continue;
                }
                for (String candidate : get(number)) {
                    if (deadMap.contains(candidate) || visited.contains(candidate)) {
                        continue;
                    }
                    visited.add(candidate);
                    queue.offer(candidate);
                }
            }
        }
        return -1;
    }

        public Set<String> calculateCandidates(String curString) {
            Set<String> result = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                char[] chars = curString.toCharArray();
                if (chars[i] == '9') {
                    chars[i] = '0';
                    result.add(new String(chars));
                    chars[i] = '8';
                    result.add(new String(chars));
                    continue;
                }
                if (chars[i] == '0') {
                    chars[i] = '9';
                    result.add(new String(chars));
                    chars[i] = '1';
                    result.add(new String(chars));
                    continue;
                }

                chars[i] = (char) (chars[i] + 1);
                result.add(new String(chars));
                chars[i] = (char) (chars[i] - 2);
                result.add(new String(chars));

            }
            return result;
        }

        public char numPrev(char x) {
            return x == '0' ? '9' : (char) (x - 1);
        }

        public char numSucc(char x) {
            return x == '9' ? '0' : (char) (x + 1);
        }

        // 枚举 status 通过一次旋转得到的数字
        public List<String> get(String status) {
            List<String> ret = new ArrayList<String>();
            char[] array = status.toCharArray();
            for (int i = 0; i < 4; ++i) {
                char num = array[i];
                array[i] = numPrev(num);
                ret.add(new String(array));
                array[i] = numSucc(num);
                ret.add(new String(array));
                array[i] = num;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}